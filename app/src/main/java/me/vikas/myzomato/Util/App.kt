package me.vikas.myzomato.Util

import me.vikas.myzomato.Model.Items
import me.vikas.myzomato.Model.Restaurant
import me.vikas.myzomato.Model.RestaurantMenuItem
import me.vikas.myzomato.R

object App {
    const val DATABASE: String = "myDatabase"
    const val USER_TABLE_NAME = "user"
    const val COLUMN_USER_ID = "userID"
    const val COLUMN_USER_USERNAME = "username"
    const val COLUMN_USER_PASSWORD = "password"
    const val COLUMN_USER_EMAIL = "email"
    const val COLUMN_USER_PHONE_NUMBER = "phone_number"
    const val COLUMN_USER_ADDRESS = "address"

    const val RESTAURANT_TABLE_NAME = "restaurant"
    const val COLUMN_RESTAURANT_ID = "restaurantID"
    const val COLUMN_RESTAURANT_NAME = "name"
    const val COLUMN_RESTAURANT_DESCRIPTION = "description"
    const val COLUMN_RESTAURANT_LOCATION = "location"
    const val COLUMN_RESTAURANT_AVERAGE_RATING = "averageRating"
    const val COLUMN_RESTAURANT_RATINGS = "ratings"
    const val COLUMN_RESTAURANT_FEATURE = "feature"
    const val COLUMN_RESTAURANT_isVEG = "isVeg"
    const val COLUMN_RESTAURANT_TYPE = "type"
    const val COLUMN_RESTAURANT_DISTANCE = "distance"
    const val COLUMN_RESTAURANT_TIME = "time"
    const val COLUMN_RESTAURANT_MENU_ID = "menuItemID"


    const val MENU_TABLE_NAME = "menu"
    const val COLUMN_MENU_ITEM_ID = "itemID"
    const val COLUMN_MENU_ITEM_NAME = "name"
    const val COLUMN_MENU_ITEM_DRAWABLE = "drawable"
    const val COLUMN_MENU_ITEM_DESCRIPTION = "description"
    const val COLUMN_MENU_ITEM_PRICE = "price"
    const val COLUMN_MENU_ITEM_AVERAGE_RATING = "averageRating"
    const val COLUMN_MENU_ITEM_RATINGS = "ratings"
    const val COLUMN_MENU_ITEM_IsVEG = "isVeg"
    const val COLUMN_MENU_RESTAURANT_ID = "restaurantID"


    const val ORDER_TABLE_NAME = "orders"
    const val COLUMN_ORDER_ITEM_ID = "orderItemID"
    const val COLUMN_ORDER_ITEM_NAME = "name"
    const val COLUMN_ORDER_ITEM_PRICE = "price"
    const val COLUMN_MENU_ITEM_CATEGORY = "category"
    const val COLUMN_ORDER_ITEM_ISVEG = "isVeg"
    const val COLUMN_ORDER_ITEM_MENU_ID = "menuID"
    const val COLUMN_ORDER_ITEM_REQUIRED_ITEMS = "isRequired"


    const val CART_TABLE = "myCart"
    const val ORDER_COMPLETED = "completedOrder"
    const val COLUMN_CART_RESTAURANT_ID = "restroID"
    const val COLUMN_CART_MENU_ID = "menuID"
    const val COLUMN_CART_ORDER_ITEM_ID = "oderItemID"
    const val COLUMN_CART_BASE_PRICE1 = "basePrice1"
    const val COLUMN_CART_BASE_PRICE2 = "basePrice2"
    const val COLUMN_CART_BASE_PRICE3 = "basePrice3"
    const val COLUMN_CART_ITEM_COUNT1 = "itemCount1"
    const val COLUMN_CART_ITEM_COUNT2 = "itemCount2"
    const val COLUMN_CART_ITEM_COUNT3 = "itemCount3"
    const val COLUMN_CART_ORDER_COMPLETED = "isCompleted"

}

fun getRestaurant(): ArrayList<Restaurant> {
    val list = ArrayList<Restaurant>()
    list.add(
        Restaurant(
            "McDonald's",
            "Delhi, 110001",
            "Hamburgers",
            " A global fast-food chain known for its hamburgers, fries, and various other items.",
            "Fast Food",
            true,
            283734,
            4.3,
            "12 km",
            "23-34"
        )
    )

    list.add(
        Restaurant(
            "Starbucks",
            "Noida, 201301",
            "Coffee",
            "A multinational coffeehouse chain famous for its coffee beverages and a variety of snacks",
            "Fast Food",
            true,
            2837634,
            4.1,
            "1-3 Km",
            "11"
        )
    )

    list.add(
        Restaurant(
            "Haldirams",
            "Delhi, 11005",
            "snacks",
            "Specil in snacks",
            "sweets",
            true,
            2837634,
            4.1,
            "45 km",
            "56"
        )
    )

    list.add(
        Restaurant(
            "Bikanerwala",
            "Delhi, 11005",
            "Sweets",
            "Full of every indian Sweets",
            "Sweets",
            true,
            2834,
            4.1,
            "45 km",
            "56"
        )
    )

    list.add(
        Restaurant(
            "KFC (Kentucky Fried Chicken)",
            "Delhi, 11005",
            "Sweets",
            "A global fast-food chain renowned for its fried chicken and other chicken-based dishes.",
            "Fast Food",
            false,
            2834,
            4.0,
            "4 km",
            "6"
        )
    )

    return list
}

fun getMenu(): ArrayList<RestaurantMenuItem> {
    val list = ArrayList<RestaurantMenuItem>()

    list.add(
        RestaurantMenuItem(
            drawable = R.drawable.img_big_mac,
            name = "Big Mac",
            description = "A classic burger with two all-beef patties, special sauce, lettuce, cheese, pickles, and onions on a sesame seed bun.",
            price = 733,
            isVeg = true,
            averageRating = 3.6,
            ratings = 345737,
            category = "Newly Launched",
            restoID = "1"
        )
    )

    list.add(
        RestaurantMenuItem(
            drawable = R.drawable.img_chicken_mcnuggets,
            name = "Chicken McNuggets",
            description = "Bite-sized pieces of breaded and fried chicken. French Fries: Golden, crispy potato fries.",
            price = 721,
            isVeg = false,
            averageRating = 4.6,
            category = "Recommended",
            ratings = 3457,
            restoID = "1"
        )
    )

    list.add(
        RestaurantMenuItem(
            drawable = R.drawable.img_mcflurry,
            name = "McFlurry",
            description = "Soft-serve ice cream mixed with various toppings and flavors.",
            price = 29,
            isVeg = true,
            category = "What's New",
            averageRating = 4.2,
            ratings = 34238757,
            restoID = "1"
        )
    )

    list.add(
        RestaurantMenuItem(
            drawable = R.drawable.img_caffe_americano,
            name = "Caffè Americano",
            description = "Espresso with added hot water.",
            price = 529,
            isVeg = true,
            category = "What's New",
            averageRating = 4.2,
            ratings = 34238757,
            restoID = "2"
        )
    )


    list.add(
        RestaurantMenuItem(
            drawable = R.drawable.img_pumpkin_spice_latte,
            name = "Pumpkin Spice Latte",
            description = "Espresso mixed with steamed milk, pumpkin spice flavoring, and whipped cream.",
            price = 159,
            isVeg = true,
            category = "Recommended",
            averageRating = 4.1,
            ratings = 34257,
            restoID = "2"
        )
    )

    list.add(
        RestaurantMenuItem(
            drawable = R.drawable.img_bacon_gouda_egg_sandwich,
            name = "Bacon, Gouda & Egg Sandwich",
            description = "Breakfast sandwich with bacon, egg, and Gouda cheese.",
            price = 259,
            category = "What's New",
            isVeg = false,
            averageRating = 4.5,
            ratings = 934257,
            restoID = "2"
        )
    )

    list.add(
        RestaurantMenuItem(
            drawable = R.drawable.img_iced_caramel_macchiato,
            name = "Iced Caramel Macchiato",
            description = "Espresso with vanilla syrup, milk, and caramel drizzle over ice.",
            price = 259,
            isVeg = true,
            category = "Newly Launched",
            averageRating = 4.1,
            ratings = 93427,
            restoID = "2"
        )
    )

    list.add(
        RestaurantMenuItem(
            drawable = R.drawable.img_sweets,
            name = "Sweets",
            description = "Rasgulla: Soft and spongy cottage cheese balls soaked in sugar syrup. Gulab Jamun: Deep-fried milk dumplings soaked in rose-scented sugar syrup. Jalebi: Deep-fried pretzel-shaped sweet soaked in saffron-infused sugar syrup.",
            price = 550,
            isVeg = true,
            category = "Newly Launched",
            averageRating = 4.9,
            ratings = 9334427,
            restoID = "3"
        )
    )

    list.add(
        RestaurantMenuItem(
            drawable = R.drawable.img_snacks,
            name = "Snacks",
            description = "Bhujia: Spicy and crispy fried noodle-like snack made from gram flour. Aloo Bhujia: Spicy potato-based snack made from mashed potatoes and gram flour. Pani Puri: Hollow puris filled with a mixture of spicy and tangy tamarind water, chickpeas, potatoes, and spices.",
            price = 660,
            isVeg = true,
            averageRating = 4.1,
            category = "Newly Launched",
            ratings = 93342427,
            restoID = "3"
        )
    )

    list.add(
        RestaurantMenuItem(
            drawable = R.drawable.img_snacks,
            name = "Snacks",
            description = "Bhujia: Spicy and crispy fried noodle-like snack made from gram flour. Aloo Bhujia: Spicy potato-based snack made from mashed potatoes and gram flour. Pani Puri: Hollow puris filled with a mixture of spicy and tangy tamarind water, chickpeas, potatoes, and spices.",
            price = 550,
            isVeg = true,
            category = "Recommended",
            averageRating = 4.2,
            ratings = 93342427,
            restoID = "4"
        )
    )

    list.add(
        RestaurantMenuItem(
            drawable = R.drawable.img_sweets,
            name = "Sweets",
            description = "Rasgulla: Soft and spongy cottage cheese balls soaked in sugar syrup. Gulab Jamun: Deep-fried milk dumplings soaked in rose-scented sugar syrup. Jalebi: Deep-fried pretzel-shaped sweet soaked in saffron-infused sugar syrup.",
            price = 450,
            isVeg = true,
            category = "Newly Launched",
            averageRating = 4.1,
            ratings = 93342427,
            restoID = "4"
        )
    )

    list.add(
        RestaurantMenuItem(
            drawable = R.drawable.img_north_indian_cuisine,
            name = "North Indian Meals",
            description = "Chole Bhature: Spicy chickpeas served with deep-fried bread (bhatura).\n" +
                    "Paneer Butter Masala: Cottage cheese cubes in a rich tomato-based curry.\n" +
                    "Dal Makhani: Creamy black lentils slow-cooked with spices.",
            price = 250,
            isVeg = true,
            category = "Newly Launched",
            averageRating = 4.6,
            ratings = 93342427,
            restoID = "4"
        )
    )

    list.add(
        RestaurantMenuItem(
            drawable = R.drawable.img_south_indian_meals,
            name = "South Indian Meals",
            description = "Masala Dosa: Thin rice crepes filled with a spiced potato mixture.\n" +
                    "Idli Sambar: Steamed rice cakes served with lentil soup (sambar) and coconut chutney.\n" +
                    "Uttapam: Thick rice pancake topped with vegetables.",
            price = 790,
            isVeg = true,
            category = "Recommended",
            averageRating = 4.2,
            ratings = 9332427,
            restoID = "4"
        )
    )

    list.add(
        RestaurantMenuItem(
            drawable = R.drawable.img_original_chicken_recipe,
            name = "Original Recipe Chicken",
            description = "Fried chicken with the secret blend of 11 herbs and spices.",
            price = 350,
            isVeg = false,
            category = "Recommended",
            averageRating = 4.7,
            ratings = 932427,
            restoID = "5"
        )
    )

    list.add(
        RestaurantMenuItem(
            drawable = R.drawable.img_chicken_pot_pie,
            name = "Chicken Pot Pie",
            description = " Creamy chicken filling encased in a flaky crust.",
            price = 450,
            isVeg = false,
            averageRating = 4.2,
            category = "What's New",
            ratings = 1932427,
            restoID = "5"
        )
    )

    list.add(
        RestaurantMenuItem(
            drawable = R.drawable.img_famous_bowl,
            name = "Famous Bowl",
            description = " Mashed potatoes, corn, crispy chicken, and gravy layered in a bowl.",
            price = 690,
            isVeg = false,
            category = "Recommended",
            averageRating = 4.1,
            ratings = 132427,
            restoID = "5"
        )
    )

    list.add(
        RestaurantMenuItem(
            drawable = R.drawable.img_hot_wings,
            name = "Hot Wings",
            description = "Spicy and flavorful chicken wings.",
            price = 290,
            isVeg = false,
            category = "Newly Launched",
            averageRating = 4.6,
            ratings = 1393827,
            restoID = "5"
        )
    )
    return list
}

fun getMenuOrderItem(): List<Items> {
    val list = ArrayList<Items>()

    list.add(
        Items(
            name = "Quater",
            price = 123,
            isVeg = true,
            isRequired = true,
            menuID = "1"
        )
    )

    list.add(
        Items(
            name = "Half",
            price = 223,
            isVeg = true,
            isRequired = false,
            menuID = "1"
        )
    )

    list.add(
        Items(
            name = "Full",
            price = 423,
            isVeg = true,
            isRequired = false,
            menuID = "1"
        )
    )

    list.add(
        Items(
            name = "Special",
            price = 550,
            isVeg = true,
            isRequired = false,
            menuID = "1"
        )
    )

    list.add(
        Items(
            name = "Small",
            price = 250,
            isVeg = false,
            isRequired = true,
            menuID = "2"
        )
    )

    list.add(
        Items(
            name = "Half",
            price = 350,
            isVeg = true,
            isRequired = false,
            menuID = "2"
        )
    )

    list.add(
        Items(
            name = "Full",
            price = 590,
            isVeg = true,
            isRequired = false,
            menuID = "2"
        )
    )

    list.add(
        Items(
            name = "Special",
            price = 650,
            isVeg = true,
            isRequired = false,
            menuID = "2"
        )
    )

    list.add(
        Items(
            name = "small",
            price = 60,
            isVeg = true,
            isRequired = true,
            menuID = "3"
        )
    )

    list.add(
        Items(
            name = "Medium",
            price = 150,
            isVeg = true,
            isRequired = false,
            menuID = "3"
        )
    )

    list.add(
        Items(
            name = "Large",
            price = 190,
            isVeg = true,
            isRequired = false,
            menuID = "3"
        )
    )

    list.add(
        Items(
            name = "Paneer Tikka",
            price = 190,
            isVeg = true,
            isRequired = true,
            menuID = "9"
        )
    )

    list.add(
        Items(
            name = "Samosa",
            price = 250,
            isVeg = true,
            isRequired = false,
            menuID = "9"
        )
    )

    list.add(
        Items(
            name = "Papdi Chaat",
            price = 90,
            isVeg = true,
            isRequired = false,
            menuID = "9"
        )
    )

    list.add(
        Items(
            name = "Paneer Tikka",
            price = 190,
            isVeg = true,
            isRequired = true,
            menuID = "10"
        )
    )

    list.add(
        Items(
            name = "Samosa",
            price = 250,
            isVeg = true,
            isRequired = false,
            menuID = "10"
        )
    )

    list.add(
        Items(
            name = "Papdi Chaat",
            price = 90,
            isVeg = true,
            isRequired = false,
            menuID = "10"
        )
    )


    list.add(
        Items(
            name = "Gulab Jaamun",
            price = 190,
            isVeg = true,
            isRequired = true,
            menuID = "8"
        )
    )

    list.add(
        Items(
            name = "Kaaju Katli",
            price = 590,
            isVeg = true,
            isRequired = false,
            menuID = "8"
        )
    )

    list.add(
        Items(
            name = "Barfi",
            price = 290,
            isVeg = true,
            isRequired = false,
            menuID = "8"
        )
    )

    list.add(
        Items(
            name = "Laddu",
            price = 280,
            isVeg = true,
            isRequired = false,
            menuID = "8"
        )
    )

    list.add(
        Items(
            name = "Gulab Jaamun",
            price = 190,
            isVeg = true,
            isRequired = true,
            menuID = "11"
        )
    )

    list.add(
        Items(
            name = "Kaaju Katli",
            price = 590,
            isVeg = true,
            isRequired = false,
            menuID = "11"
        )
    )

    list.add(
        Items(
            name = "Barfi",
            price = 290,
            isVeg = true,
            isRequired = false,
            menuID = "11"
        )
    )

    list.add(
        Items(
            name = "Laddu",
            price = 280,
            isVeg = true,
            isRequired = false,
            menuID = "11"
        )
    )


    list.add(
        Items(
            name = "Chole Bhature",
            price = 80,
            isVeg = true,
            isRequired = true,
            menuID = "12"
        )
    )

    list.add(
        Items(
            name = "Paneer Butter Masala",
            price = 180,
            isVeg = true,
            isRequired = false,
            menuID = "12"
        )
    )

    list.add(
        Items(
            name = "Dal Makhani",
            price = 120,
            isVeg = true,
            isRequired = false,
            menuID = "12"
        )
    )

    list.add(
        Items(
            name = "Masala Dosa",
            price = 180,
            isVeg = true,
            isRequired = true,
            menuID = "13"
        )
    )

    list.add(
        Items(
            name = "Idli Sambar",
            price = 120,
            isVeg = true,
            isRequired = false,
            menuID = "13"
        )
    )

    list.add(
        Items(
            name = "Uttapam",
            price = 90,
            isVeg = true,
            isRequired = false,
            menuID = "13"
        )
    )

    list.add(
        Items(
            name = "for 2",
            price = 90,
            isVeg = false,
            isRequired = false,
            menuID = "14"
        )
    )

    list.add(
        Items(
            name = "for 4",
            price = 190,
            isVeg = false,
            isRequired = false,
            menuID = "14"
        )
    )

    list.add(
        Items(
            name = "for 5",
            price = 250,
            isVeg = false,
            isRequired = false,
            menuID = "14"
        )
    )

    list.add(
        Items(
            name = "for 1",
            price = 250,
            isVeg = false,
            isRequired = false,
            menuID = "15"
        )
    )

    list.add(
        Items(
            name = "for 2",
            price = 390,
            isVeg = false,
            isRequired = false,
            menuID = "15"
        )
    )

    list.add(
        Items(
            name = "for 5",
            price = 600,
            isVeg = false,
            isRequired = false,
            menuID = "15"
        )
    )

    list.add(
        Items(
            name = "Small",
            price = 250,
            isVeg = false,
            isRequired = false,
            menuID = "17"
        )
    )


    list.add(
        Items(
            name = "Medium",
            price = 390,
            isVeg = false,
            isRequired = false,
            menuID = "17"
        )
    )

    list.add(
        Items(
            name = "Large",
            price = 550,
            isVeg = false,
            isRequired = false,
            menuID = "17"
        )
    )

    list.add(
        Items(
            name = "Large + Coke",
            price = 650,
            isVeg = false,
            isRequired = false,
            menuID = "17"
        )
    )

    return list
}