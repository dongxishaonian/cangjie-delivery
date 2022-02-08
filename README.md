[![Code Scanning](https://github.com/dongxishaonian/cangjie-delivery/actions/workflows/code_scanning.yml/badge.svg)](https://github.com/dongxishaonian/cangjie-delivery/actions/workflows/code_scanning.yml)
[![pages-build-deployment](https://github.com/dongxishaonian/cangjie-delivery/actions/workflows/pages/pages-build-deployment/badge.svg)](https://github.com/dongxishaonian/cangjie-delivery/actions/workflows/pages/pages-build-deployment)

# cangjie-delivery
## 项目介绍
🔥**仓颉交付**——专注于开发者，致力于全过程改善并规范化你的软件开发/交付流程！
### Why me？
作为一个开发者，我们工作的职责之一就是软件开发，并且这也是我们最关注的。软件开发的工作要怎么做呢？一千个人心中有一千个哈姆雷特。每个开发者都有自己的一个工具箱，都有擅长的技术、熟悉的语言、个性十足的IDE...,很明显这是一件好事，抛开社会上的一些言论，软件开发本质并不是一个劳动密集型的工作，他鼓励学习，更鼓励创新。但是，作为个体的我们，并不是为自己来做软件开发的，我们会在城市的写字楼里团队合作。我们发挥着自己的长处，同时我们也互相配合，有共同的工作目标，最重要的目标就是**写出为用户真正带来价值的软件**。

软件行业在几十年时间里，已经发生了数次的变革以及带来了不少的创新的实用理论。瀑布流开发模型、敏捷开发、极限编程、精益开发、持续集成、Devops......,这些理论和实践的出现无不在帮助我们更好的进行软件开发这项团队工作，并更快更好的写出有价值的软件。但其实对于目前很多的开发人员而言，可能并没有精力或者兴趣去学习掌握这些。

如果有一个产品能够汲取软开开发中的那些有用的理论或实践，并在实际工作中协助软件开发人员去实践他们并获得相应的价值，怎么样呢？？？
#### 一些想法
首先我们可以分析下大多数开发人员熟知的三个开发阶段：
![未命名绘图](https://user-images.githubusercontent.com/17216322/149130768-f229c806-c433-412e-b664-31d05955265e.jpg)

下面通过一个示例来展示一个较完整的开发流程模型图：
![流程示例](https://user-images.githubusercontent.com/17216322/149130545-f2097fcf-dd01-4c94-aa60-4b407f5d348d.png)

开发流程中的各个环节同时会涉及到不同的工具：
![process-tools](https://user-images.githubusercontent.com/17216322/152800324-1713b11d-3bab-44b7-8b30-24f9e4069dc0.png)

在实际的开发过程中，根据每个团队的不同，对以上每个阶段的细化也会存在不少差异。这些差异可能和分支模型、采用的开发方法、面向的用户群体...有关，并且随着时间的推移和日常经验的积累不断演进。

当团队内部拥有一个约定的开发流程框架时，每个成员都有义务去维护和实践这个流程，进而，才能进行后续的优化和演进。

### 产品介绍
综上所述，建立这个项目的初衷有如下（包括但不仅限于）：
* 帮助开发团队设计并统一软件开发流程。
* 帮助开发者更有效地实践软件开发流程。
* 通过实践反馈，帮助团队持续优化和演进开发流程。
* 通过工具化的手段，有效的对开发者研发效能进行度量，并帮助开发者提升。
* ...

#### 一些特色
##### 拒绝研发工具“竖井”
目前市面上的大部分研发流程管理平台都会和自己的产品进行强绑定，导致公司或者研发团队在切换到这些商业平台的时候，必须连带的放弃掉当前研发流程中正在使用的一些工具,转而使用商业平台提供的，如：需求任务管理工具、代码仓库、测试管理工具...
这其中各种工具的切换，非常地费时费力，期间对公司的业务发展也可能带来不少影响。
我们开始关注流程了，但是我们一直在使用的工具也有错？
##### 低侵入
使用该工具可做到对研发活动的低侵入，在尽量不影响当前研发工具链的前提下，规范化软件研发流程，对研发流程进行更好的可视化。
##### 更灵活的流程编排
部分专注于研发流程的商业平台会拥有一套内置的，有平台特色的研发流程。对于需要研发流程自定义的场景，并没有提供太多的空间。而该工具将流程编排作为关键功能，将流程设定权更多的交给使用者。
##### 更简单的扩展
该项目会预置多个涉及研发流程各环节的并且被广泛使用的工具，如与trello、github、jenkins的交互。若当前用户正在使用的工具不再内，则可以参考扩展文档，基于当前项目代码进行二次开发，实现工具的连接。
##### 完全开源
该项目源代码、文档资源等完全按照“Apache-2.0 License”进行开源，对项目参与者，外部开发者完全透明，欢迎开发者贡献代码！

## code quality
本项目代码质量使用 [jetbrains-Qodana](https://www.jetbrains.com/help/qodana/welcome.html) 进行检查保证，检查方式基于**Github Action+Qodana**的方式实现。
### 使用Qadano的主要场景
* 参与者（贡献者）在发起向main分支的Pull Request时，将触发代码质量的检查，不合格的代码将无法进行后续的合并操作。
* 项目维护者将代码直接推送到本仓库时，会触发代码质量的检查。

本项目Qadano详情页： [**点击前往**](https://www.techflower.cn/cangjie-delivery/) 。

## 项目管理
目前本项目使用 [Trello](https://trello.com/home) 进行 需求、开发计划、Issue等等的管理，本项目公开的看板链接： [点击前往](https://trello.com/invite/b/yHlvEavj/f86e4dabba68f43a92e6978f3b99f568/cangjie-delivery)

### 关于看板的权限
* 如果你想了解或掌握该项目的 功能现状、开发计划、问题追踪... ，可以点击上面的链接进入看板，访问者仅拥有看板的浏览权限。
* 如果你是项目的维护者，你将拥有看板的编辑权限，你将有权对看板中的各类事项进行编辑（[如何成为项目维护者？](https://www.techflower.cn)）。

## 相关链接
* trello: [https://trello.com/invite/b/yHlvEavj/f86e4dabba68f43a92e6978f3b99f568/cangjie-delivery](https://trello.com/invite/b/yHlvEavj/f86e4dabba68f43a92e6978f3b99f568/cangjie-delivery)
* Qadano: [https://www.techflower.cn/cangjie-delivery/](https://www.techflower.cn/cangjie-delivery/)
