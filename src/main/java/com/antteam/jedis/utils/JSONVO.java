/**   
* @Title: JSONVO.java 
* @Package com.antteam.jedis.utils 
* @Description: TODO(用一句话描述该文件做什么) 
* @author niceling
* @date 2016年2月29日 上午10:32:18 
* @version V1.0   
*/
package com.antteam.jedis.utils;

import java.io.Serializable;

/**   
* @Package com.antteam.jedis.utils 
* @Description: TODO(用一句话描述该文件做什么) 
* @author niceling
* @date 2016年2月29日 上午10:32:18   
*/

public class JSONVO implements Serializable{
	
	private static final long serialVersionUID = -4191943921642747959L;
	private Integer channel_id;
	private String channel_name;
	private Integer index;
	private String url;
	private Integer display;
	public Integer getChannel_id() {
		return channel_id;
	}
	public void setChannel_id(Integer channel_id) {
		this.channel_id = channel_id;
	}
	public String getChannel_name() {
		return channel_name;
	}
	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getDisplay() {
		return display;
	}
	public void setDisplay(Integer display) {
		this.display = display;
	}
	
}
