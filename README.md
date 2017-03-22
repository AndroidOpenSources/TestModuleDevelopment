###### 框架：一个基于模块化运作
###### 本框架采用了retrofit2+AsynTaskLoader的方式实现异步加载。
>*框架体系： Activity+多Fragment，采用Uri的形式启动当前业务组件

---
 1. [关于框架](#1)
    * [1.1 背景](#1.1)
    * [1.2 框架运行机制](#1.2)
 2. [框架实现机制](#2)
    * [2.1 LauncherModel](#2.1)
    * [2.2 ComponetAppication](#2.2)
    * [2.3 流程实现](#2.3)
    
---
<h2 id="1">1.关于框架</h2>
######本框架是基于插件化的形式运作，同时也支持组件的接入以及组件的打包操作,本框架支持灰度测试。为保证组件化和插件化的同时运作，本框架遵循Android 的Launcher模式，通过intent-filter的形式进行互动操作。通过Activity和多Fragment的运作方式，使得Activity自身无需在处理多个业务操作，仅负责对Fragment进行管理和切换。Fragment则处理业务。
![框架运行流程](https://github.com/AndroidOpenSources/TestModuleDevelopment/blob/master/框架运行流程.png)

<h3 id="1.2">1.1 背景</h3>
######技术背景
<h3 id="1.2">1.2 框架运行机制</h3> 




