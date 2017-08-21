package vip.vipegg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.vipegg.common.Constants;
import vip.vipegg.dao.CountlimitDao;
import vip.vipegg.model.CountLimit;
import vip.vipegg.util.Utils;

import java.util.List;

@Service
public class ValidateService{
	@Autowired
	private CountlimitDao countlimitDao ;

	private static long TIME = 2*60*60*1000;
	//是否可以重试
	public int getLimitCount(String ip){
		int maxLimit = Constants.ADMIN_LOGIN_ERROR_COUNT ;
		
		List<CountLimit> list = this.countlimitDao.findByIp(ip) ;
		if(list.size()==0){
			return maxLimit ;
		}else{
			CountLimit countLimit = list.get(0) ;
			if(Utils.getTimestamp().getTime()- countLimit.getCreateTime().getTime() < TIME){
				return maxLimit - countLimit.getCount() ;
			}else{
				return maxLimit ;
			}
		}
	}
	
	//记录一次错误记录
	public void updateLimitCount(String ip){
		if(Constants.closeLimit){return;}
		List<CountLimit> list = this.countlimitDao.findByIp(ip) ;
		if(list.size()==0){
			CountLimit countLimit = new CountLimit(1, ip) ;
			this.countlimitDao.save(countLimit) ;
		}else{
			CountLimit countLimit = list.get(0) ;
			if(Utils.getTimestamp().getTime()- countLimit.getCreateTime().getTime() < TIME){
				countLimit.setCount(countLimit.getCount()+1) ;
				countLimit.setCreateTime(Utils.getTimestamp()) ;
				this.countlimitDao.attachDirty(countLimit) ;
			}else{
				countLimit.setCount(1) ;
				countLimit.setCreateTime(Utils.getTimestamp()) ;
				this.countlimitDao.attachDirty(countLimit) ;
			}
		}
	}
}
