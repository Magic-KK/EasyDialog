#### 自定义Dialog 1.0
## 主要特点

1.默认dialog  单按钮和双按钮
2.自定义dialog 单按钮和多按钮
3.自定义多按钮dialog


## 使用
1.添加类库
```gradle
 compile 'com.github.zhangkexpz:EasyDialog:v1.0'
```

2.默认布局dialog 单按钮使用方法
  final EasyDialog dialog = new EasyDialog(EasyDialog.DEFAULT_ONE_BTN, this);
        dialog.show();
        //设置标题
        dialog.setTitle("这是标题");
        //设置内容
        dialog.setContent("这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容");
        //设置按钮名字
        dialog.setBtnName("确定");

        dialog.setDefaultClickOne(new IEasyDialog.IBtnClickOne() {
            @Override
            public void click() {
                Toast.makeText(OneBtnActivity.this, "点击", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }
    
