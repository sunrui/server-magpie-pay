package com.project.spider.core.spider.dealy.dto.categoryInfo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryInfo {
    private List<CategoryInfoNavMenu> navMenuList;
}

/*
{
	"code": 200,
	"data": {
		"navMenuList": [{
			"id": 21055,
			"isAll": 0,
			"showName": "Kitchen",
			"url": "",
			"0": {
				"contentCode": "5408",
				"id": 21059,
				"targetId": "5408",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/6e30b03b-3235-4a40-950d-bcdfb8524dd9.jpg",
				"targetName": "Drinkware",
				"targetStyle": 3,
				"targetType": 1,
				"url": "drinkware-c5408?goBack=1",
				"spm": "CAT.C20987.C21055.C21059"
			},
			"1": {
				"contentCode": "5410",
				"id": 21061,
				"targetId": "5410",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/90807ce5-7ea8-4140-98c5-51bc1616f93d.jpg",
				"targetName": "Flatware",
				"targetStyle": 3,
				"targetType": 1,
				"url": "flatware-c5410?goBack=1",
				"spm": "CAT.C20987.C21055.C21061"
			},
			"2": {
				"contentCode": "5412",
				"id": 21063,
				"targetId": "5412",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/2abb078c-86d5-4270-92d3-a5d541b9aa82.jpg",
				"targetName": "Kitchen Tools",
				"targetStyle": 3,
				"targetType": 1,
				"url": "kitchen-tools-c5412?goBack=1",
				"spm": "CAT.C20987.C21055.C21063"
			},
			"3": {
				"contentCode": "5414",
				"id": 21065,
				"targetId": "5414",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/08620b99-1d64-44b3-9b0c-5ebb78f77a76.png",
				"targetName": "Bakeware",
				"targetStyle": 3,
				"targetType": 1,
				"url": "bakeware-c5414?goBack=1",
				"spm": "CAT.C20987.C21055.C21065"
			},
			"4": {
				"contentCode": "5416",
				"id": 21067,
				"targetId": "5416",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/cc09e869-535a-4156-9780-1f75984519ec.png",
				"targetName": "Kitchen&Table Linens",
				"targetStyle": 3,
				"targetType": 1,
				"url": "kitchen-table-linens-c5416?goBack=1",
				"spm": "CAT.C20987.C21055.C21067"
			},
			"5": {
				"contentCode": "5418",
				"id": 21069,
				"targetId": "5418",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/f07b9306-1e7b-4343-8078-0cb10e79cc16.jpg",
				"targetName": "Cookware",
				"targetStyle": 3,
				"targetType": 1,
				"url": "cookware-c5418?goBack=1",
				"spm": "CAT.C20987.C21055.C21069"
			}
		}, {
			"id": 20989,
			"isAll": 1,
			"showName": "Home Decor",
			"url": "home-decor-c5344?goBack=1",
			"spm": "CAT.C20987.C5344.CX",
			"0": {
				"contentCode": "5350",
				"id": 20993,
				"targetId": "5350",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/141f31c4-51e7-4e74-8620-9721e1f0814f.jpg",
				"targetName": "Wall Stickers",
				"targetStyle": 3,
				"targetType": 1,
				"url": "wall-stickers-c5350?goBack=1",
				"spm": "CAT.C20987.C20989.C20993"
			},
			"1": {
				"contentCode": "5354",
				"id": 20997,
				"targetId": "5354",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/04c17234-8a17-4cdb-bf1e-676d46de90fe.jpg",
				"targetName": "Wall Shelves",
				"targetStyle": 3,
				"targetType": 1,
				"url": "wall-shelves-c5354?goBack=1",
				"spm": "CAT.C20987.C20989.C20997"
			},
			"2": {
				"contentCode": "5356",
				"id": 20999,
				"targetId": "5356",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/07a33473-efa1-482f-844e-3a68672b9834.jpg",
				"targetName": "Wall Paper",
				"targetStyle": 3,
				"targetType": 1,
				"url": "wall-paper-c5356?goBack=1",
				"spm": "CAT.C20987.C20989.C20999"
			},
			"3": {
				"contentCode": "5358",
				"id": 21001,
				"targetId": "5358",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/4bfb3ff9-3f9f-47e7-926d-04c44846741b.jpg",
				"targetName": "Lighting & Lamps",
				"targetStyle": 3,
				"targetType": 1,
				"url": "lighting-lamps-c5358?goBack=1",
				"spm": "CAT.C20987.C20989.C21001"
			},
			"4": {
				"contentCode": "5360",
				"id": 21003,
				"targetId": "5360",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/7e9f4bbb-0c71-4b68-a36d-54b60f2b5035.jpg",
				"targetName": "Candles & Holders",
				"targetStyle": 3,
				"targetType": 1,
				"url": "candles-holders-c5360?goBack=1",
				"spm": "CAT.C20987.C20989.C21003"
			},
			"5": {
				"contentCode": "5362",
				"id": 21005,
				"targetId": "5362",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/72bfe939-3a0a-41da-b0f2-1f754e3ed89f.jpg",
				"targetName": "Decorative Accents",
				"targetStyle": 3,
				"targetType": 1,
				"url": "decorative-accents-c5362?goBack=1",
				"spm": "CAT.C20987.C20989.C21005"
			},
			"6": {
				"contentCode": "5366",
				"id": 21009,
				"targetId": "5366",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/461864f0-a9a7-4337-bdd7-278511078c79.jpg",
				"targetName": "Vases & Flowers",
				"targetStyle": 3,
				"targetType": 1,
				"url": "vases-flowers-c5366?goBack=1",
				"spm": "CAT.C20987.C20989.C21009"
			},
			"7": {
				"contentCode": "5368",
				"id": 21011,
				"targetId": "5368",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/d72ca546-5b1b-43d7-be20-7bf90eea67dc.jpg",
				"targetName": "Small Type Furniture",
				"targetStyle": 3,
				"targetType": 1,
				"url": "small-type-furniture-c5368?goBack=1",
				"spm": "CAT.C20987.C20989.C21011"
			},
			"8": {
				"contentCode": "5372",
				"id": 22531,
				"targetId": "5372",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/104586a3-5e86-44a1-b7fc-d5b1424c29d0.jpg",
				"targetName": "More",
				"targetStyle": 3,
				"targetType": 1,
				"url": "more-c5372?goBack=1",
				"spm": "CAT.C20987.C20989.C22531"
			}
		}, {
			"id": 21071,
			"isAll": 0,
			"showName": "Storage & Organization",
			"url": "",
			"0": {
				"contentCode": "5424",
				"id": 21077,
				"targetId": "5424",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/cd7d8c56-c53c-4c90-ae3f-07727c1c14a2.jpg",
				"targetName": "Storage Boxes",
				"targetStyle": 3,
				"targetType": 1,
				"url": "storage-boxes-c5424?goBack=1",
				"spm": "CAT.C20987.C21071.C21077"
			},
			"1": {
				"contentCode": "5426",
				"id": 21079,
				"targetId": "5426",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/71141997-45b5-4499-bcc7-f5e9d25b98ce.jpg",
				"targetName": "Storage Bags",
				"targetStyle": 3,
				"targetType": 1,
				"url": "storage-bags-c5426?goBack=1",
				"spm": "CAT.C20987.C21071.C21079"
			},
			"2": {
				"contentCode": "5428",
				"id": 21081,
				"targetId": "5428",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/aec32769-3574-4d84-9be5-82a98fec7b52.png",
				"targetName": "Makeup Organizers",
				"targetStyle": 3,
				"targetType": 1,
				"url": "makeup-organizers-c5428?goBack=1",
				"spm": "CAT.C20987.C21071.C21081"
			},
			"3": {
				"contentCode": "5430",
				"id": 21083,
				"targetId": "5430",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/04853463-d898-4fd4-ab82-b5617b423b82.jpg",
				"targetName": "Jewelry Organizers",
				"targetStyle": 3,
				"targetType": 1,
				"url": "jewelry-organizers-c5430?goBack=1",
				"spm": "CAT.C20987.C21071.C21083"
			},
			"4": {
				"contentCode": "5432",
				"id": 25763,
				"targetId": "5432",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/1cef5a0b-a6ce-4a2c-a567-cd6966c70e4e.png",
				"targetName": "Storage Baskets",
				"targetStyle": 3,
				"targetType": 1,
				"url": "storage-baskets-c5432?goBack=1",
				"spm": "CAT.C20987.C21071.C25763"
			},
			"5": {
				"contentCode": "5436",
				"id": 25765,
				"targetId": "5436",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/d0b2bdf1-671b-4164-a76a-2a51a2c46d0a.png",
				"targetName": "More",
				"targetStyle": 3,
				"targetType": 1,
				"url": "more-c5436?goBack=1",
				"spm": "CAT.C20987.C21071.C25765"
			}
		}, {
			"id": 21033,
			"isAll": 0,
			"showName": "Home Essentials",
			"url": "",
			"0": {
				"contentCode": "5388",
				"id": 21037,
				"targetId": "5388",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/14f63055-eed1-4f51-bd5d-2ebfb6871035.png",
				"targetName": "Cleaning Tools",
				"targetStyle": 3,
				"targetType": 1,
				"url": "cleaning-tools-c5388?goBack=1",
				"spm": "CAT.C20987.C21033.C21037"
			},
			"1": {
				"contentCode": "5390",
				"id": 21039,
				"targetId": "5390",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/e773820f-fd65-46ea-958e-8c98b454690a.jpg",
				"targetName": "Drying Tools",
				"targetStyle": 3,
				"targetType": 1,
				"url": "drying-tools-c5390?goBack=1",
				"spm": "CAT.C20987.C21033.C21039"
			},
			"2": {
				"contentCode": "5392",
				"id": 21041,
				"targetId": "5392",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/50c24739-850b-48b0-a75e-8518554167cc.jpg",
				"targetName": "Towels",
				"targetStyle": 3,
				"targetType": 1,
				"url": "towels-c5392?goBack=1",
				"spm": "CAT.C20987.C21033.C21041"
			},
			"3": {
				"contentCode": "5394",
				"id": 21043,
				"targetId": "5394",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/2f5f2081-dbb1-47e9-bed3-374dce0fd84c.png",
				"targetName": "Bath Accessories",
				"targetStyle": 3,
				"targetType": 1,
				"url": "bath-accessories-c5394?goBack=1",
				"spm": "CAT.C20987.C21033.C21043"
			},
			"4": {
				"contentCode": "5400",
				"id": 21049,
				"targetId": "5400",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/5d1b75c8-916e-4b5d-a7a4-7fb48568b402.png",
				"targetName": "Mirrors",
				"targetStyle": 3,
				"targetType": 1,
				"url": "mirrors-c5400?goBack=1",
				"spm": "CAT.C20987.C21033.C21049"
			},
			"5": {
				"contentCode": "5404",
				"id": 21053,
				"targetId": "5404",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/eb989f5c-149d-4837-ac2c-d6607fe5e480.png",
				"targetName": "More",
				"targetStyle": 3,
				"targetType": 1,
				"url": "more-c5404?goBack=1",
				"spm": "CAT.C20987.C21033.C21053"
			}
		}, {
			"id": 21017,
			"isAll": 0,
			"showName": "Home Linens",
			"url": "",
			"0": {
				"contentCode": "5374",
				"id": 21021,
				"targetId": "5374",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/b2ff57cf-f0d7-4a2a-a1af-2134c785b749.jpg",
				"targetName": "Bedding",
				"targetStyle": 3,
				"targetType": 1,
				"url": "bedding-c5374?goBack=1",
				"spm": "CAT.C20987.C21017.C21021"
			},
			"1": {
				"contentCode": "5376",
				"id": 21023,
				"targetId": "5376",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/894ae54a-8cf1-4f0b-be85-495e886c30d9.jpg",
				"targetName": "Rugs & Mats",
				"targetStyle": 3,
				"targetType": 1,
				"url": "rugs-mats-c5376?goBack=1",
				"spm": "CAT.C20987.C21017.C21023"
			},
			"2": {
				"contentCode": "5378",
				"id": 21025,
				"targetId": "5378",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/8be7f392-130a-45c0-be57-9b5b7845859c.jpg",
				"targetName": "Slippers",
				"targetStyle": 3,
				"targetType": 1,
				"url": "slippers-c5378?goBack=1",
				"spm": "CAT.C20987.C21017.C21025"
			},
			"3": {
				"contentCode": "5382",
				"id": 21029,
				"targetId": "5382",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/094f604c-0cb4-43ce-ad1b-94bbffffa014.png",
				"targetName": "Covers",
				"targetStyle": 3,
				"targetType": 1,
				"url": "covers-c5382?goBack=1",
				"spm": "CAT.C20987.C21017.C21029"
			},
			"4": {
				"contentCode": "5384",
				"id": 21031,
				"targetId": "5384",
				"targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/654fd944-bb63-4d67-bd92-496499447d17.png",
				"targetName": "More",
				"targetStyle": 3,
				"targetType": 1,
				"url": "more-c5384?goBack=1",
				"spm": "CAT.C20987.C21017.C21031"
			}
		}],
		"analysisTrack": {
			"contentViewMobile": "content-view-list",
			"jollychicDomain": "m.dealy1688.com",
			"jollychicCountry": "SA",
			"jollychicLanguage": "en",
			"jollychicCurrency": "sar",
			"gaTrackingData": [],
			"awTrackingData": {
				"event": "listingpage_view",
				"ecomm_pagetype": "other",
				"ecomm_prodid": "",
				"ecomm_totalvalue": "",
				"ecomm_category": "category_list",
				"user_id": "5cfa645ad6899fb6"
			},
			"criteoTrackingData": {
				"hashedEmail": "",
				"siteType": "m",
				"eventType": "viewList",
				"orderId": "",
				"category": "category_list",
				"itemInfo": ""
			},
			"criteoTrackPixelEvent": "viewList",
			"criteoTrackPixelCategory": "category_list",
			"jollyCatId": 20987,
			"jollychicOrderTotalVal": "",
			"jollychicOrderId": "",
			"jollyTotalValCurrency": 0,
			"jollyDeepLinkPath": ""
		}
	},
	"message": "Success!"
}
 */
