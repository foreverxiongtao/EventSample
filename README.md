# EventSample
传统事件捕获和冒泡的流程解析


android的事件机制统一来说，还是比较复杂，但是应用的地方还是比较多，所以现在准备抽点时间出来整理一下。

其实android的事件机制还是有点类似于js中的事件机制的。
涉及到的两个过程 

1.事件的捕获

2.事件的冒泡

##事件的捕获:
事件由外层的view捕获，然后一层一层的传递给内层的view,最后传递给更能够接受该事件的最小的view,至此事件的捕获过程算是完成了。

##事件的冒泡:
事件从最小单元的view依次向外层的view传递，依次向外冒泡；

但是android的事件往往比这复杂，原因主要是因为主要表现在可以控制每层事件是否继续传递（由事件分发和事件拦截协同进行），以及事件的具体消费（由事件消响应进行，但需要注意的是，事件分发自身也具有事件消费能力）。

这就是本文提及到事件分发，事件拦截和事件响应这三个过程。
android中不同的控件对应的事件分发，事件拦截和事件响应稍有不同。activity本身不具备事件拦截。而最小的view单元是不具备事件的分发和事件拦截功能。
好了直接讲原理吧:
# 1-----事件分发 #
对应android中的方法是：
public boolean dispatchTouchEvent(MotionEvent ev),我们需要注意的是这个方法的返回值.

当有监听到事件时，首先由Activity的捕获到，进入事件分发处理流程。无论是Activity还是View，如前文所说，事件分发自身也具有消费能力，

1.如果返回值是true，表明当前的事件已经在在本层中不会再分发，事件会分发给当前 View 并由 dispatchTouchEvent 而且事件在分发过程中已经被消耗掉， 方法进行消费到这里事件的处理已经结束，

2.返回值为false,这里我们要分为两种情况：

1>如果当前的view的获取的事件是来自于view,那么该事件将会被冒泡返回给父view，然后交由父view的onTouchEvent方法进行处理。

2>如果当前view获取的事件是来自于activity，那么当前的事件将会冒泡给activity，然后交由activity的onTouchEvent方法进行处理。

如果当前的返回值是super.dispatchTouchEvent()，那么事件将主动分发给当前view的onInterceptTouchEvent方法。


#2------事件拦截：
对应的android的方法是：public boolean onInterceptTouchEvent(MotionEvent ev) 
当前的view的dispatchTouchEvent方法返回值是super.dispatchTouchEvent(),那么当前的view的onInterceptTouchEvent方法的拦截规程如下:

1>如果当前的返回值为true,标示事件将会被拦截，那么被拦截的事件将会交由当前的view的onTouchEvent进行处理

2>如果当前的返回值为false,那么当前的事件就不会进行拦截，那么view事件能够得以传递给子view,并且由子view的dispatchTouchEvent（）方法进行处理。

3>如果当前的view的返回值为super.interceptTouchEvent（）,那么当前的事件也是不会进行拦截的，并且传递给子view的dispatchTouchEvent()进行处理。


#3-------事件响应:
对应的方法为public boolean onTouchEvent(MotionEvent ev)

1>如果当前的返回值是true,那么表明当前的事件已经被消费掉，那么事件就不会冒泡给父view,

2>如果当前的返回值是false,那么事件将会在onTouchEvent处理后在冒泡回传给父view,同时交由父view的onTouchEvent进行处理。

3>如果当前的的返回值是super.onTouchEvent(MotionEvent ev)，处理的逻辑和false其实是一样的。

那么我们可以发现，dispatchTouchEvent方法的返回值无论是true,还是false,事件都会被消费掉，无法进行分发了，只有当返回值为super.dispatchTouchEvent()才有分发的资格，而且interceptTouchEvent的返回值不为true，不拦截的情况下，子view才会能捕获到事件，
