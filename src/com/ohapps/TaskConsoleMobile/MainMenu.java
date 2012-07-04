package com.ohapps.TaskConsoleMobile;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainMenu extends ListActivity {
	
	
	String menuItems[] = {
			"View Tasks",
			"View Projects",
			"View Notes"
	};
	
	
	String menuClasses[] = {
			"TasksList",
			"ProjectsList",
			"NotesList"
	};
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        
    	super.onCreate(savedInstanceState);
    	setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,menuItems));    	        
        
    }

	
    @Override
	protected void onListItemClick(ListView list, View view, int position, long id){
		
		super.onListItemClick(list, view, position, id);		
		String menuClass = menuClasses[position];				
				
		try{									
			Class<?> clazz = Class.forName("com.ohapps.TaskConsoleMobile." + menuClass);
			Intent intent = new Intent(this,clazz);
			startActivity(intent);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
	}
    
	
}