/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author wndgk
 */
public abstract class Managing {
    private String name;
    private SearchStrategy searchStrategy;
    private ManagementStrategy managementStrategy;
    
    public Managing(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void search(){
        searchStrategy.search();
    }
    
    public void update(){
        managementStrategy.update();
    }
    
    public void modify(){
        managementStrategy.modify();
    }

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public void setManagementStrategy(ManagementStrategy managementStrategy) {
        this.managementStrategy = managementStrategy;
    }
    
    
}
