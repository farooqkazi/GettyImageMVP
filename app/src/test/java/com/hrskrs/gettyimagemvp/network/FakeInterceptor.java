package com.hrskrs.gettyimagemvp.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by hrskrs on 4/14/2017.
 */

public class FakeInterceptor implements Interceptor {

  private final static String MOCK_RESPONSE = "{\n" +
      "  \"result_count\": 94682,\n" +
      "  \"images\": [\n" +
      "    {\n" +
      "      \"id\": \"181264085\",\n" +
      "      \"asset_family\": \"editorial\",\n" +
      "      \"caption\": \"BERLIN, GERMANY - SEPTEMBER 20:  A customer tries out the new Apple iPhone 5C smartphone at the Berlin Apple Store on the first day of sales on September 20, 2013 in Berlin, Germany. The new iPhone 5S and 5C phones went on sale all over the world today and hundreds of customers waited outside the Berlin store in the rain to be among the first to buy the new phones starting at 8am.  (Photo by Sean Gallup/Getty Images)\",\n" +
      "      \"collection_code\": \"NEW\",\n" +
      "      \"collection_id\": 56,\n" +
      "      \"collection_name\": \"Getty Images News\",\n" +
      "      \"display_sizes\": [\n" +
      "        {\n" +
      "          \"is_watermarked\": false,\n" +
      "          \"name\": \"thumb\",\n" +
      "          \"uri\": \"https://media.gettyimages.com/photos/customer-tries-out-the-new-apple-iphone-5c-smartphone-at-the-berlin-picture-id181264085?b=1&k=6&m=181264085&s=170x170&h=2Q0iuPkb3QbfPM_HWwuWSiXdswOVNZc6h1uy2c2xEpg=\"\n" +
      "        }\n" +
      "      ],\n" +
      "      \"license_model\": \"rightsmanaged\",\n" +
      "      \"max_dimensions\": {\n" +
      "        \"height\": 2047,\n" +
      "        \"width\": 3000\n" +
      "      },\n" +
      "      \"title\": \"Apple Begins Selling iPhone 5 S/C In Berlin\"\n" +
      "    },\n" +
      "    {\n" +
      "      \"id\": \"151811539\",\n" +
      "      \"asset_family\": \"creative\",\n" +
      "      \"caption\": null,\n" +
      "      \"collection_code\": \"OJO\",\n" +
      "      \"collection_id\": 237,\n" +
      "      \"collection_name\": \"OJO Images\",\n" +
      "      \"display_sizes\": [\n" +
      "        {\n" +
      "          \"is_watermarked\": false,\n" +
      "          \"name\": \"thumb\",\n" +
      "          \"uri\": \"https://media.gettyimages.com/photos/smiling-businesswoman-checking-cell-phone-picture-id151811539?b=1&k=6&m=151811539&s=170x170&h=RRJouvSDzONUaPBoOE9Pxt5TCpP8AzO4nGphoB7nbaI=\"\n" +
      "        }\n" +
      "      ],\n" +
      "      \"license_model\": \"royaltyfree\",\n" +
      "      \"max_dimensions\": {\n" +
      "        \"height\": 3987,\n" +
      "        \"width\": 4384\n" +
      "      },\n" +
      "      \"title\": \"Smiling businesswoman checking cell phone\"\n" +
      "    },\n" +
      "    {\n" +
      "      \"id\": \"200545827-001\",\n" +
      "      \"asset_family\": \"creative\",\n" +
      "      \"caption\": null,\n" +
      "      \"collection_code\": \"DV\",\n" +
      "      \"collection_id\": 13,\n" +
      "      \"collection_name\": \"DigitalVision\",\n" +
      "      \"display_sizes\": [\n" +
      "        {\n" +
      "          \"is_watermarked\": false,\n" +
      "          \"name\": \"thumb\",\n" +
      "          \"uri\": \"https://media.gettyimages.com/photos/crowd-of-people-using-cell-phones-in-street-smiling-picture-id200545827-001?b=1&k=6&m=200545827-001&s=170x170&h=eAfggqmLjlJdPjHEVHprMVwUyroVqGQJb63HfimVUA8=\"\n" +
      "        }\n" +
      "      ],\n" +
      "      \"license_model\": \"royaltyfree\",\n" +
      "      \"max_dimensions\": {\n" +
      "        \"height\": 4072,\n" +
      "        \"width\": 5424\n" +
      "      },\n" +
      "      \"title\": \"Crowd of people using cell phones in street, smiling\"\n" +
      "    },\n" +
      "    {\n" +
      "      \"id\": \"151811593\",\n" +
      "      \"asset_family\": \"creative\",\n" +
      "      \"caption\": null,\n" +
      "      \"collection_code\": \"OJO\",\n" +
      "      \"collection_id\": 237,\n" +
      "      \"collection_name\": \"OJO Images\",\n" +
      "      \"display_sizes\": [\n" +
      "        {\n" +
      "          \"is_watermarked\": false,\n" +
      "          \"name\": \"thumb\",\n" +
      "          \"uri\": \"https://media.gettyimages.com/photos/smiling-businesswoman-looking-down-at-cell-phone-in-cafe-window-picture-id151811593?b=1&k=6&m=151811593&s=170x170&h=yinnGD-L5bU9eBFaQMqKk7_Db7jgNBBoM7qORr93zC8=\"\n" +
      "        }\n" +
      "      ],\n" +
      "      \"license_model\": \"royaltyfree\",\n" +
      "      \"max_dimensions\": {\n" +
      "        \"height\": 3506,\n" +
      "        \"width\": 4985\n" +
      "      },\n" +
      "      \"title\": \"Smiling businesswoman looking down at cell phone in cafe window\"\n" +
      "    },\n" +
      "    {\n" +
      "      \"id\": \"200462290-001\",\n" +
      "      \"asset_family\": \"creative\",\n" +
      "      \"caption\": null,\n" +
      "      \"collection_code\": \"DV\",\n" +
      "      \"collection_id\": 13,\n" +
      "      \"collection_name\": \"DigitalVision\",\n" +
      "      \"display_sizes\": [\n" +
      "        {\n" +
      "          \"is_watermarked\": false,\n" +
      "          \"name\": \"thumb\",\n" +
      "          \"uri\": \"https://media.gettyimages.com/photos/woman-sitting-at-table-in-bar-looking-at-mobile-phone-smiling-picture-id200462290-001?b=1&k=6&m=200462290-001&s=170x170&h=ZRphJAO6no9NMpT6FjRQ0GmycUFgl_kuY8NUQHzUhLA=\"\n" +
      "        }\n" +
      "      ],\n" +
      "      \"license_model\": \"royaltyfree\",\n" +
      "      \"max_dimensions\": {\n" +
      "        \"height\": 3328,\n" +
      "        \"width\": 4992\n" +
      "      },\n" +
      "      \"title\": \"Woman sitting at table in bar, looking at mobile phone, smiling\"\n" +
      "    },\n" +
      "    {\n" +
      "      \"id\": \"143071438\",\n" +
      "      \"asset_family\": \"creative\",\n" +
      "      \"caption\": null,\n" +
      "      \"collection_code\": \"OJO\",\n" +
      "      \"collection_id\": 237,\n" +
      "      \"collection_name\": \"OJO Images\",\n" +
      "      \"display_sizes\": [\n" +
      "        {\n" +
      "          \"is_watermarked\": false,\n" +
      "          \"name\": \"thumb\",\n" +
      "          \"uri\": \"https://media.gettyimages.com/photos/student-using-cell-phone-outdoors-picture-id143071438?b=1&k=6&m=143071438&s=170x170&h=JEd0WE90WaIZSaDtDaWuSUZ2YttSozJ7zdPEhKQG4Yg=\"\n" +
      "        }\n" +
      "      ],\n" +
      "      \"license_model\": \"royaltyfree\",\n" +
      "      \"max_dimensions\": {\n" +
      "        \"height\": 3429,\n" +
      "        \"width\": 5144\n" +
      "      },\n" +
      "      \"title\": \"Student using cell phone outdoors\"\n" +
      "    },\n" +
      "    {\n" +
      "      \"id\": \"486452556\",\n" +
      "      \"asset_family\": \"editorial\",\n" +
      "      \"caption\": \"BERLIN, GERMANY - SEPTEMBER 04:  Visitors try out the Honor 7 smartphone at the Huawei stand at the 2015 IFA consumer electronics and appliances trade fair on September 4, 2015 in Berlin, Germany. The 2015 IFA will be open to the public from September 4-9.  (Photo by Sean Gallup/Getty Images)\",\n" +
      "      \"collection_code\": \"NEW\",\n" +
      "      \"collection_id\": 56,\n" +
      "      \"collection_name\": \"Getty Images News\",\n" +
      "      \"display_sizes\": [\n" +
      "        {\n" +
      "          \"is_watermarked\": false,\n" +
      "          \"name\": \"thumb\",\n" +
      "          \"uri\": \"https://media.gettyimages.com/photos/visitors-try-out-the-honor-7-smartphone-at-the-huawei-stand-at-the-picture-id486452556?b=1&k=6&m=486452556&s=170x170&h=u8b6tArXFWh6YxDMWToSxJaaqczEHbbLLi0H9GLHqUU=\"\n" +
      "        }\n" +
      "      ],\n" +
      "      \"license_model\": \"rightsmanaged\",\n" +
      "      \"max_dimensions\": {\n" +
      "        \"height\": 3000,\n" +
      "        \"width\": 4500\n" +
      "      },\n" +
      "      \"title\": \"IFA 2015 Consumer Electronics And Appliances Trade Fair\"\n" +
      "    },\n" +
      "    {\n" +
      "      \"id\": \"606021900\",\n" +
      "      \"asset_family\": \"editorial\",\n" +
      "      \"caption\": \"BERLIN, GERMANY - SEPTEMBER 16:  A visitor tries out an Apple iPhone 7 on the first day of sales of the new phone at the Berlin Apple store on September 16, 2016 in Berlin, Germany. The new phone comes in two sizes, one with a 4.7 inch display, the other with a 5.5 inch display.   (Photo by Sean Gallup/Getty Images)\",\n" +
      "      \"collection_code\": \"NEW\",\n" +
      "      \"collection_id\": 56,\n" +
      "      \"collection_name\": \"Getty Images News\",\n" +
      "      \"display_sizes\": [\n" +
      "        {\n" +
      "          \"is_watermarked\": false,\n" +
      "          \"name\": \"thumb\",\n" +
      "          \"uri\": \"https://media.gettyimages.com/photos/visitor-tries-out-an-apple-iphone-7-on-the-first-day-of-sales-of-the-picture-id606021900?b=1&k=6&m=606021900&s=170x170&h=Kmlddxd4YcEKADO1FZCUaJn6KKmmLgO69HB2ogpqpIg=\"\n" +
      "        }\n" +
      "      ],\n" +
      "      \"license_model\": \"rightsmanaged\",\n" +
      "      \"max_dimensions\": {\n" +
      "        \"height\": 3456,\n" +
      "        \"width\": 5184\n" +
      "      },\n" +
      "      \"title\": \"Apple Fans Await iPhone 7\"\n" +
      "    },\n" +
      "    {\n" +
      "      \"id\": \"471306730\",\n" +
      "      \"asset_family\": \"editorial\",\n" +
      "      \"caption\": \"SYDNEY, AUSTRALIA - APRIL 27:  A woman takes an iPhone photo of part of the flower wall that reads '#keephopealive', as part of an Amnesty international vigil for the Bali 9 duo, Andrew Chan and Myuran Sukumaran in a last ditch effort to sway the Indonesian Government to halt the planned executions of the two on April 27, 2015 in Sydney, Australia.  Chan is one of the nine Australians accused by Indonesian Police of drug trafficking on April 17, 2005.  (Photo by Cole Bennetts/Getty Images)\",\n" +
      "      \"collection_code\": \"NEW\",\n" +
      "      \"collection_id\": 56,\n" +
      "      \"collection_name\": \"Getty Images News\",\n" +
      "      \"display_sizes\": [\n" +
      "        {\n" +
      "          \"is_watermarked\": false,\n" +
      "          \"name\": \"thumb\",\n" +
      "          \"uri\": \"https://media.gettyimages.com/photos/woman-takes-an-iphone-photo-of-part-of-the-flower-wall-that-reads-as-picture-id471306730?b=1&k=6&m=471306730&s=170x170&h=87Egye7WljQLXquEyD08xgcU5V46oynLpAEBBongYFA=\"\n" +
      "        }\n" +
      "      ],\n" +
      "      \"license_model\": \"rightsmanaged\",\n" +
      "      \"max_dimensions\": {\n" +
      "        \"height\": 3840,\n" +
      "        \"width\": 5760\n" +
      "      },\n" +
      "      \"title\": \"Activists Call For Stop To Bali Nine Duo Executions\"\n" +
      "    },\n" +
      "    {\n" +
      "      \"id\": \"181281527\",\n" +
      "      \"asset_family\": \"editorial\",\n" +
      "      \"caption\": \"BEIJING, CHINA - SEPTEMBER 20: A customer inspects the new iPhone at the Wangfujing flagship store on September 20, 2013 in Beijing, China. Apple launched the new iPhone 5C model that will run iOS 7 is made from hard-coated polycarbonate and comes in various colors and the iPhone 5S that features fingerprint recognition security. (Photo by Lintao Zhang/Getty Images)\",\n" +
      "      \"collection_code\": \"NEW\",\n" +
      "      \"collection_id\": 56,\n" +
      "      \"collection_name\": \"Getty Images News\",\n" +
      "      \"display_sizes\": [\n" +
      "        {\n" +
      "          \"is_watermarked\": false,\n" +
      "          \"name\": \"thumb\",\n" +
      "          \"uri\": \"https://media.gettyimages.com/photos/customer-inspects-the-new-iphone-at-the-wangfujing-flagship-store-on-picture-id181281527?b=1&k=6&m=181281527&s=170x170&h=9NitlrKD1pypV3LxEAjQS6kazyGu4_X5jWMuvzKrI-4=\"\n" +
      "        }\n" +
      "      ],\n" +
      "      \"license_model\": \"rightsmanaged\",\n" +
      "      \"max_dimensions\": {\n" +
      "        \"height\": 3137,\n" +
      "        \"width\": 4705\n" +
      "      },\n" +
      "      \"title\": \"Apple Launches iPhone 5s And 5c In China\"\n" +
      "    }\n" +
      "  ]\n" +
      "}";

  @Override
  public Response intercept(Chain chain) throws IOException {
    Response response = null;
    String responseString = MOCK_RESPONSE;
    response = new Response.Builder()
        .code(200)
        .message(responseString)
        .request(chain.request())
        .protocol(Protocol.HTTP_1_0)
        .body(ResponseBody.create(MediaType.parse("application/json"), responseString.getBytes()))
        .addHeader("content-type", "application/json")
        .build();

    return response;
  }
}
