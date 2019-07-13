# Android_Expandable_Recycler_View
This android tutorial implements basic recycler View that can be expanded. It can be done by hiding view and simple animation.

The RecyclerView widget is a more advanced and flexible version of ListView.

To implement Recycler View You need to add library dependency in your ```build.gradle``` of App module file.

If you are using Support Library the add below line.
```
dependencies {
    implementation 'com.android.support:recyclerview-v7:28.0.0'
}
```
Or else if you are using androidX then add below line.
```
dependencies {
    implementation 'androidx.recyclerview:recyclerview:1.0.0'
}
```

Now create Recycler View in ```MainActivity.xml```
```
<androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recycler_view"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```

Connect RecyclerView with <a href="https://github.com/Vijay-Tahelramani/Android_Expandable_Recycler_View/blob/master/Expandable_recycler_view/app/src/main/java/com/example/expandable_recycler_view/MainActivity.java">```MainActivity.java```</a> Class in ```onCreate()``` Menthod and  connect it to a layout manager.
```
recyclerView = findViewById(R.id.recycler_view);
recyclerView.setLayoutManager(new LinearLayoutManager(this));
```
Create a layput file named <a href="https://github.com/Vijay-Tahelramani/Android_Expandable_Recycler_View/blob/master/Expandable_recycler_view/app/src/main/res/layout/product_items.xml">```product_items.xml```</a>, This layout will handle the all the Views for each item in List.

Now We Need Adapter Class and a class for list that handles getter and setter for each variable.

Here I have created a class named <a href="https://github.com/Vijay-Tahelramani/Android_Expandable_Recycler_View/blob/master/Expandable_recycler_view/app/src/main/java/com/example/expandable_recycler_view/Products.java">```Products.java```</a>.
Create getter methods for all the variables , setter method for booloean expanded and constructor with all the parameters except variable expanded.

Now create an adapter class will inflate the ```product_items.xml``` and bind all the data to the views and will display on RecyclerView.
Here I have created a class named <a href="https://github.com/Vijay-Tahelramani/Android_Expandable_Recycler_View/blob/master/Expandable_recycler_view/app/src/main/java/com/example/expandable_recycler_view/CustomRecyclerAdapter.java">```CustomRecyclerAdapter.java```</a>.
You must extend the RecyclerView.Adapter class. This object creates views for items, and replaces the content of some of the views with new data items when the original item is no longer visible.

Here ```OnCreateViewHolder()``` method inflates ```product_items.xml```. 
The layout manager calls the adapter's onCreateViewHolder() method. That method needs to construct a RecyclerView.ViewHolder and set the view it uses to display the content. 

The type of the ViewHolder must match the type declared in the Adapter class.

Here I have a CustomViewHolder Class that matches with Adapter Class.

```public class CustomViewHolder extends RecyclerView.ViewHolder``` matches with ```public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.CustomViewHolder>```

The ```onBindViewHolder()``` method the appropriate Products data set to each row. I have a created a method ```bind()```. It will handle the visibility of our View and make it visibile or invisible based on the value of boolean. This method also binds the data of list to our TextViews.

Method ```getItemCount()``` returns the size of our List.

Now, In <a href="https://github.com/Vijay-Tahelramani/Android_Expandable_Recycler_View/blob/master/Expandable_recycler_view/app/src/main/java/com/example/expandable_recycler_view/MainActivity.java">```MainActivity.java```</a> file create a list add some data. Then Create a object of Adapter Class pass the list to it and setAdapter to the RecyclerView.

The Below Line Handles the normal animation for expanded View for Our RecyclerView.
```
((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
```

In our case, item fades out/fades in, making it look like a blink. We prevent that by disabling that animation.

Screen Preview
<table>
<tr>
  <td><img src="https://github.com/Vijay-Tahelramani/Android_Expandable_Recycler_View/blob/master/Images/normal.png" width="300"/></td>
  <td><img src="https://github.com/Vijay-Tahelramani/Android_Expandable_Recycler_View/blob/master/Images/expanded.png" width="300"/></td>
  </tr>
</table>

