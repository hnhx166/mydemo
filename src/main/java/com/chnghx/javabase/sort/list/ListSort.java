package com.chnghx.javabase.sort.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

/**
 * 
*    
* 项目名称：mydemo   
* 类名称：ListSort
* 
* 类描述：    以目录按须显示为例， 实现方式 Comparator
* 
* 
* 
* 创建人：guohaixiang  
* 创建时间：2018年1月19日 下午5:07:04   
* 修改人：Administrator   
* 修改时间：2018年1月19日 下午5:07:04   
* 修改备注：   
* @version 1.0
*
 */
public class ListSort {

	/**
	 * 排序方法升序排序
	 * @param list
	 */
	public static void sort(List<Catalog> list) {
		if(CollectionUtils.isNotEmpty(list)) {
		    Collections.sort(list, new Comparator<Catalog>() {
		        public int compare(Catalog o1, Catalog o2) {
		            if(o1.getNum() < o2.getNum()) {//小于时返回 -1  -----如果此处 小于号（<）改为大于号（>） , else if 的大于号(>)改为小于号(<) ，则是降序    ， 测试通过
		            	return -1;
		            }else if(o1.getNum() > o2.getNum()) {//大于时返回 1
		            	return 1;
		            }else {//相等时返回 0
		            	return 0;
		            }
		        }
		    });
		}
	}

	public static void main(String[] args) {
		Catalog root = initData();
		List<Catalog> data = root.getChildren();
		//原始排序
		for(Catalog pcatalog : data) {
			System.out.println("父节点名称：" + pcatalog.getCatalogName()  + " ， 父节点顺序" + pcatalog.getNum());
			List<Catalog> cc = pcatalog.getChildren();
			if(CollectionUtils.isNotEmpty(cc)) {
				for(Catalog ccatalog : cc) {
					System.out.println("****************子节点名称：" + ccatalog.getCatalogName()  + " ， 子节点顺序" + ccatalog.getNum());
				}
			}
		}
		System.out.println("***********************************************************");
		
		//目录根据显示顺序num排序
		sort(data);//此处可有使用 root.sortChildren()方法
		//排序后输出
		for(Catalog pcatalog : data) {
			System.out.println("父节点名称：" + pcatalog.getCatalogName()  + " ， 父节点顺序" + pcatalog.getNum());
			List<Catalog> cc = pcatalog.getChildren();
			pcatalog.sortChildren();
			if(CollectionUtils.isNotEmpty(cc)) {
				for(Catalog ccatalog : cc) {
					System.out.println("****************子节点名称：" + ccatalog.getCatalogName()  + " ， 子节点顺序" + ccatalog.getNum());
				}
			}
		}

	}
	
	/**
	 * 初始化数据
	 * @return
	 */
	private static Catalog initData() {
		Catalog root = new Catalog("根目录", 0);
		//一级目录列表
		List<Catalog> data = new ArrayList<Catalog>();
		Catalog pc3 = new Catalog("第3个目录", 3);
		Catalog pc1 = new Catalog("第1个目录", 1);
		Catalog pc2 = new Catalog("第2个目录", 2);
		Catalog pc5 = new Catalog("第5个目录", 5);
		Catalog pc4 = new Catalog("第4个目录", 4);
		
		//根节点(可有可无，按照树形结构设计，故此有一个根节点)
		root.setChildren(data);
		
		//子节点
		data.add(pc3);
		data.add(pc1);
		data.add(pc2);
		data.add(pc5);
		data.add(pc4);
		
		//二级目录
		List<Catalog> children1 = new ArrayList<Catalog>();
		Catalog p1cc4 = new Catalog("第1个父节点目录4", 4);
		Catalog p1cc1 = new Catalog("第1个父节点目录1", 1);
		Catalog p1cc3 = new Catalog("第1个父节点目录3", 3);
		Catalog p1cc5 = new Catalog("第1个父节点目录5", 5);
		Catalog p1cc2 = new Catalog("第1个父节点目录2", 2);
		children1.add(p1cc4);
		children1.add(p1cc1);
		children1.add(p1cc3);
		children1.add(p1cc5);
		children1.add(p1cc2);
		pc1.setChildren(children1);
		
		//二级目录
		List<Catalog> children2 = new ArrayList<Catalog>();
		Catalog p2cc1 = new Catalog("第2个父节点目录1", 1);
		Catalog p2cc3 = new Catalog("第2个父节点目录3", 3);
		Catalog p2cc5 = new Catalog("第2个父节点目录5", 5);
		Catalog p2cc2 = new Catalog("第2个父节点目录2", 2);
		Catalog p2cc4 = new Catalog("第2个父节点目录4", 4);
		children2.add(p2cc1);
		children2.add(p2cc3);
		children2.add(p2cc5);
		children2.add(p2cc2);
		children2.add(p2cc4);
		pc2.setChildren(children2);
		
		
		return root;
	}
	
}
