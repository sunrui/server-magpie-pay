package com.project.spider.core.spider.dealy.dto.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Category {
    private String bgColor;
    private List<CategoryNavMenu> navMenuList;
    // 此处使用的大写
    @JsonProperty("MenuList")
    private List<CategoryMenu> menuList;
}

/*
{
	"code": 200,
	"data": {
		"bgColor": "#f2f2f2",
		"navMenuList": [{
			"id": 22533,
			"showName": "Featured",
			"icoUrl": ""
		}, {
			"id": 20987,
			"showName": "Home&Living",
			"icoUrl": ""
		}, {
			"id": 21307,
			"showName": "Electronics ",
			"icoUrl": ""
		}, {
			"id": 21091,
			"showName": "Beauty",
			"icoUrl": ""
		}, {
			"id": 20849,
			"showName": "Kids & Moms",
			"icoUrl": ""
		}, {
			"id": 19311,
			"showName": "Women's Clothing",
			"icoUrl": ""
		}, {
			"id": 20757,
			"showName": "Men's Collection",
			"icoUrl": ""
		}, {
			"id": 19717,
			"showName": "Accessories",
			"icoUrl": ""
		}, {
			"id": 19413,
			"showName": "Bags",
			"icoUrl": ""
		}, {
			"id": 19393,
			"showName": "Shoes",
			"icoUrl": ""
		}, {
			"id": 21133,
			"showName": "More Choice",
			"icoUrl": ""
		}],
		"MenuList": [{
			"id": 22535,
			"isAll": 0,
			"showName": "Hot",
			"url": "",
			"0": {
				"contentCode": "4886",
				"id": 35366,
				"targetId": "4886",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/2380fdd4-5b3c-4390-b739-f9108e587b02.jpg",
				"targetName": "T-Shirts",
				"targetStyle": 3,
				"targetType": 1,
				"url": "t-shirts-c4886?goBack=1",
				"spm": "CAT.C22533.C22535.C35366"
			},
			"1": {
				"contentCode": "4936",
				"id": 22539,
				"targetId": "4936",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/05a16d54-1a47-4dbe-a87e-183e4bbfc5e6.jpg",
				"targetName": "Dresses",
				"targetStyle": 3,
				"targetType": 1,
				"url": "dresses-c4936?goBack=1",
				"spm": "CAT.C22533.C22535.C22539"
			},
			"2": {
				"contentCode": "4970",
				"id": 34896,
				"targetId": "4970",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/c62684d3-8d28-4a2d-a203-8ab880dd77ab.jpg",
				"targetName": "Pajamas",
				"targetStyle": 3,
				"targetType": 1,
				"url": "pajamas-c4970?goBack=1",
				"spm": "CAT.C22533.C22535.C34896"
			},
			"3": {
				"contentCode": "5304",
				"id": 35360,
				"targetId": "5304",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/cc1f924d-c158-43b6-a728-fad6df2f1e0f.jpg",
				"targetName": "Baby",
				"targetStyle": 3,
				"targetType": 1,
				"url": "baby-c5304?goBack=1",
				"spm": "CAT.C22533.C22535.C35360"
			},
			"4": {
				"contentCode": "4906",
				"id": 35378,
				"targetId": "4906",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/7e5ca844-9163-42da-8414-55694e17c51a.png",
				"targetName": "Sandals",
				"targetStyle": 3,
				"targetType": 1,
				"url": "sandals-c4906?goBack=1",
				"spm": "CAT.C22533.C22535.C35378"
			},
			"5": {
				"contentCode": "4914",
				"id": 24271,
				"targetId": "4914",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/d7e010ad-a868-4801-8567-7d04453b152d.jpg",
				"targetName": "Handbags",
				"targetStyle": 3,
				"targetType": 1,
				"url": "handbags-c4914?goBack=1",
				"spm": "CAT.C22533.C22535.C24271"
			},
			"6": {
				"contentCode": "5346",
				"id": 26522,
				"targetId": "5346",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/78a4dd23-4697-4e19-b20a-617187bb81c0.jpg",
				"targetName": "Home Décor",
				"targetStyle": 3,
				"targetType": 1,
				"url": "home-d-C3-A9cor-c5346?goBack=1",
				"spm": "CAT.C22533.C22535.C26522"
			},
			"7": {
				"contentCode": "5406",
				"id": 35362,
				"targetId": "5406",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/efe5d173-1946-45ee-b627-c5d4de72c022.jpg",
				"targetName": "Kitchen",
				"targetStyle": 3,
				"targetType": 1,
				"url": "kitchen-c5406?goBack=1",
				"spm": "CAT.C22533.C22535.C35362"
			},
			"8": {
				"contentCode": "5466",
				"id": 35381,
				"targetId": "5466",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/645417cd-9eff-446a-a797-8bad737b745b.jpg",
				"targetName": "Appliances",
				"targetStyle": 3,
				"targetType": 1,
				"url": "appliances-c5466?goBack=1",
				"spm": "CAT.C22533.C22535.C35381"
			}
		}, {
			"id": 25261,
			"isAll": 0,
			"showName": "New",
			"url": "",
			"0": {
				"contentCode": "5188",
				"id": 35383,
				"targetId": "5188",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/ee43c699-a0a1-4692-b9e2-3da5bd86944f.jpg",
				"targetName": "Plus Size",
				"targetStyle": 3,
				"targetType": 1,
				"url": "plus-size-c5188?goBack=1",
				"spm": "CAT.C22533.C25261.C35383"
			},
			"1": {
				"contentCode": "5242",
				"id": 35374,
				"targetId": "5242",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/c4fd28b4-53cc-46ae-aa6a-ae2c0b6b2c7b.jpg",
				"targetName": "Girls' Wear",
				"targetStyle": 3,
				"targetType": 1,
				"url": "girls-wear-c5242?goBack=1",
				"spm": "CAT.C22533.C25261.C35374"
			},
			"2": {
				"contentCode": "5132",
				"id": 35370,
				"targetId": "5132",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/13d22d18-3b5d-45f5-839d-cfda3d9cc02c.jpg",
				"targetName": "Necklaces",
				"targetStyle": 3,
				"targetType": 1,
				"url": "necklaces-c5132?goBack=1",
				"spm": "CAT.C22533.C25261.C35370"
			},
			"3": {
				"contentCode": "5374",
				"id": 35372,
				"targetId": "5374",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/b2ff57cf-f0d7-4a2a-a1af-2134c785b749.jpg",
				"targetName": "Bedding",
				"targetStyle": 3,
				"targetType": 1,
				"url": "bedding-c5374?goBack=1",
				"spm": "CAT.C22533.C25261.C35372"
			},
			"4": {
				"contentCode": "5476",
				"id": 34906,
				"targetId": "5476",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/dd55a893-29a7-4d16-ad09-ba8e0fd5baf2.jpg",
				"targetName": "Car Electronics",
				"targetStyle": 3,
				"targetType": 1,
				"url": "car-electronics-c5476?goBack=1",
				"spm": "CAT.C22533.C25261.C34906"
			},
			"5": {
				"contentCode": "5008",
				"id": 35368,
				"targetId": "5008",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/20dda884-ee51-407e-bf8c-231829599bee.jpg",
				"targetName": "Hair Accessories",
				"targetStyle": 3,
				"targetType": 1,
				"url": "hair-accessories-c5008?goBack=1",
				"spm": "CAT.C22533.C25261.C35368"
			}
		}]
	},
	"message": "Success!"
}
 */
