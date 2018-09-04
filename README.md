
# com.inspur.cordova.SFZTakePlugin
这是一个拍摄身份证照片的cordova插件，支持android

#安装方法
`cordova plugin add https://github.com/namedjw/com.inspur.cordova.SFZTakePlugin.git --save`

#调用方法
```
declare var LocationPlugin;

takephote(){
  SFZTakePlugin.takephoto(res => {
    alert(JSON.stringify(res));
  },err=>{
    alert(err);
  });
}
```
