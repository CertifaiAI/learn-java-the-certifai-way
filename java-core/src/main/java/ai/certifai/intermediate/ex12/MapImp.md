# Map <> HashMap
A Map is an object that maps keys to values.
<p align="center">
 <img src="metadata/key-value.jpg">
</p>

## **What To Do**
In program MapImp, Map<>HashMap is implemented to store country name as key and country code as value.
<p align="center">
 <img src="metadata/country_code.jpg">
</p>

**When do we use Map<>HashMap** \
Maps are used for when you want to associate a key with a value and Lists are an ordered collection.

**Example Scenario:** 
- Item names matching with products
<p align="center">
 <img src="metadata/receipt.jpg">
</p>
- User IDs matching with names
<p align="center">
 <img src="metadata/key-value2.jpg">
</p>

## **Sample Input** 
get Malaysia
delete Malaysia
delete Malaysia
add Singapore 65

## **Sample Output** 
60
True
False
True

## **Key Takeaways** 

**Properties of Map:**
- Unique Key. There should not be duplicates key.
- Keys should be all belongs to one type of Object. Likewise for values.
    -   Example
        -   Map keyValue = new HashMap<String, String>();
        -   Map countryCode = new HashMap<String, Integer>();
        -   Map method = new HashMap<Integer, Double>();
        
- Not an ordered collection. Does not return keys and values in the same order they have been inserted.



## **Above & Beyond**

