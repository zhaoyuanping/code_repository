package com.chlab.zylht.util;


import java.util.HashMap;

import com.github.pagehelper.Page;

/**
 * 分页数据封装
 * @author c
 *
 */
public final class PageData extends HashMap<Object, Object>{
	
	private static final long serialVersionUID = 1L;
	
	int pageNum;
	int pageSize; 
	int start;
	int end;
	int total;
	int pages;
	
	private Page<?> datas;
	
	public PageData(Page<?> page){
		init(page, "datas");
	}
	
	public PageData(Page<?> page,String root){
		init(page, root);
	}
	
	private void init(Page<?> page,String root){
		datas = page;
		this.put("pageNum", page.getPageNum());
		this.put("pageSize", page.getPageSize());
		this.put("start", page.getStartRow());
		this.put("end", page.getEndRow());
		this.put("total", page.getTotal());
		this.put("pages", page.getPages());
		this.put(root, page.getResult());
	}
	
	public Page<?> getDatas(){
		
		return datas;
	}
}
