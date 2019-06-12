package com.xuxx.ms.mall.manager.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.xuxx.ms.mall.entity.Result;
import com.xuxx.ms.mall.seller.api.SellerService;
import com.xuxx.ms.mall.seller.entity.TbSeller;

/**
 * 
 * 用户认证类
 * @author xuxx
 * @date 2019-05-14 11:14:50
 * @since JDK 1.8
 *
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private SellerService sellerService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<GrantedAuthority> grantAuths = new ArrayList<GrantedAuthority>();
		grantAuths.add(new SimpleGrantedAuthority("ROLE_SELLER"));

		Result<TbSeller> data = sellerService.findOne(username);
		if (data != null && data.getData() != null && StringUtils.isNotBlank(data.getData().getName())) {
			TbSeller seller =  data.getData();
			if (seller.getStatus().equals("1")) {
				return new User(username, seller.getPassword(), grantAuths);
			} else {
				return null;
			}
		}
		throw new UsernameNotFoundException(username);
	}
}
