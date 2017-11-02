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
```java
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
```
2.默认布局dialog 双按钮使用方法
```java
        final EasyDialog dialog = new EasyDialog(EasyDialog.DEFAULT_TWO_BTN, this);
        dialog.show();
        //设置标题
        dialog.setTitle("这是标题");
        //设置内容
        dialog.setContent("这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容");
        //设置左侧按钮名字
        dialog.setLeftBtnName("确定");
        //设置右侧按钮名字
        dialog.setRightBtnName("取消");


        dialog.setDefaultClickTwo(new IEasyDialog.IBtnClickTwo() {
            @Override
            public void leftOnClick() {
                Toast.makeText(TwoBtnActivity.this, "left click", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }

            @Override
            public void rightOnClick() {
                Toast.makeText(TwoBtnActivity.this, "right click", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
```



3.自定义dialog 单按钮使用方法

```java
  final EasyDialog dialog = new EasyDialog(R.layout.dialog_one, this);
        dialog.show();
        dialog.setOneBtnDialog(R.id.button_ok, new IEasyDialog.IBtnClickOne() {
            @Override
            public void click() {
                Toast.makeText(OneBtnCustomizeActivity.this, "click", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
```

4.自定义dialog 双按钮使用方法
```java
  final EasyDialog dialog = new EasyDialog(R.layout.dialog_two, this);
        dialog.show();
        dialog.setBtnClickTwo(R.id.button_cancal, R.id.button_ok, new IEasyDialog.IBtnClickTwo() {
            @Override
            public void leftOnClick() {
                Toast.makeText(TwoBtnCustomzeActivity.this, "left onclick", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }

            @Override
            public void rightOnClick() {
                Toast.makeText(TwoBtnCustomzeActivity.this, "right onclick", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

```

