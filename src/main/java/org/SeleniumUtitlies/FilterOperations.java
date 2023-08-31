package org.SeleniumUtitlies;

public enum FilterOperations {
    ADDTOCART("add_to_cart"),
    VALUES("values"),
    TOTALCOUNT("count");
    final String filter;
    FilterOperations(String filter){
        this.filter =filter;
    }
    public String getValue(){
        return filter;
    }


}
