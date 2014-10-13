FilePickerLibrary
=================

[![Android Arsenal](http://img.shields.io/badge/Android%20Arsenal-FilePickerLibrary-blue.svg?style=flat)](http://android-arsenal.com/details/1/785)

Simple library that allows for picking of files and directories. This is a clean and simple way to allow your user to easily select a file. This library is inspired by Android L and the new Material Design guidelines adding to its sleekness and beauty.


![image] (images/main_framed.png)

<h2>Requirements</h2>
Min SDK Level is 14 or Android IceCreamSandwich

<h2>Dependency</h2>

Clone this repository or download the zip. Then extract to your computer. Simply import the library to your project but only include the FPlib module (that's where the library is). If you're using Android Studio then import a module and only include the FPlib module. See the license for usage terms.

<h2>Usage</h2>
Simply do the following.
```java
Intent filePickerIntent = new Intent(this, FilePickerActivity.class);
filePickerIntent.putIntExtra(FilePicker.REQUEST_CODE, FilePickerActivity.REQUEST_DIRECTORY);
startActivityForResult(filePickerIntent, FilePickerActivity.REQUEST_DIRECTORY); 
```
Make sure to add the int extra for your request code. You can also request for a file path instead of a directory. See the javadocs for more info. To get the file path do the following.

```java
  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {

    if(requestCode == FilePickerActivity.REQUEST_DIRECTORY 
    && resultCode == RESULT_OK) {
    
        String filePath = data.
                getStringExtra(FilePickerActivity.FILE_EXTRA_DATA_PATH);
                if(filePath != null) {
                //do something with filePath...
                }
  }
    super.onActivityResult(requestCode, resultCode, data);
  }
```

<h2>Customization</h2>
You can change the header background in the activity by adding resorce ids to your calling intent as int extras. Below is an example.

```java
Intent filePickerIntent = new Intent(this, FilePickerActivity.class);
filePickerIntent.putIntExtra(FilePicker.REQUEST_CODE, FilePickerActivity.REQUEST_DIRECTORY);
filePickerIntent.putIntExtra(FilePicker.INTENT_EXTRA_COLOR_ID, R.color.myColor);
startActivityForResult(filePickerIntent, FilePickerActivity.REQUEST_DIRECTORY); 
```
You can also change the theme for the activity to make it look like a dialog.
```java
Intent filePickerDialogIntent = new Intent(getActivity(), FilePickerActivity.class);
filePickerDialogIntent.putExtra(FilePickerActivity.THEME_TYPE, ThemeType.DIALOG);
filePickerDialogIntent.putExtra(FilePickerActivity.REQUEST_CODE, FilePickerActivity.REQUEST_FILE);
startActivityForResult(filePickerDialogIntent, FilePickerActivity.REQUEST_FILE);
```
In addition you can set a mime type that you want the user to select. The activity will not return a result until that type of file is selected. For example: 

```java
Intent filePicker = new Intent(getActivity(), FilePickerActivity.class);
filePicker.putExtra(FilePickerActivity.SCOPE_TYPE, FileScopeType.ALL);
filePicker.putExtra(FilePickerActivity.REQUEST_CODE, FilePickerActivity.REQUEST_FILE);
filePicker.putExtra(FilePickerActivity.INTENT_EXTRA_COLOR_ID, android.R.color.holo_green_dark);
filePicker.putExtra(FilePickerActivity.MIME_TYPE, FileType.PNG);
startActivityForResult(filePicker, FilePickerActivity.REQUEST_FILE);
```
![image](images/custom_main_framed.png)


                    

<h2>Demo App</h2>
* **Check out the sample on google play.**

       [![Get it on Google Play](http://www.android.com/images/brand/get_it_on_play_logo_small.png)](https://play.google.com/store/apps/details?id=com.devpaul.filepicker)
	 
<h2>Todo</h2>
Push to Maven Central

<h2> Notes </h2>
Please just use the FileScopeType.ALL for now. When doing further testing I discovered a slight cosmetic issue with the list adapter that I'm trying to work out. The library will still work, the list will just look bad. This should hopefully be fixed shortly.

<h2>Developed By</h2>
**Paul Tsouchlos**
