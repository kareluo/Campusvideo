## Campusvideo

> [云窗2.0](http://vod.shou.edu.cn/)

> [校园视频3.0 - 很久前开发上传的一个版本](https://www.pgyer.com/cvideo)

云窗校园视频在2013年上线校园内网，用户可以在校园内网观看高清流畅的视频，并且免费无广告，因此受到了很多人的欢迎。现在已经无法使用，我于当年9月份开始着手开发Android手机客户端，现在已经放弃继续改进，现将所经历的一系列过程分享如下：

- 抓取接口

	通过抓取PC客户端请求，得到了一些列请求接口，几乎全部是xml文件路径，这个不难理解，服务端都是分布搭建在各个学校内（服务器配置较低），因此几乎是静态网站，解析等处理过程全部放在客户端完成。

- 开源视频播放库

	当时使用的是[Vitamio](https://www.vitamio.org/)(个人免费)，后来更换成了Bilibili的开源库[ijkplayer](https://github.com/Bilibili/ijkplayer)，14年时很多视频都被加密了（视频源文件前160字节取反），后对ijkplayer底层解码部分修改了一些。两个库使用过程都做过一些改动。

- 加入下载等功能

	可以将视频缓存到本地，以及一些其他的功能。

- 打算开源

	后来很长一段时间没有这么维护，再后来6.0等都无法使用后，迁移到了Android Studio开发了一点就发布了，再后来打算去掉一些繁杂的功能，简化一些然后开源出去，现在进行到一半发现无法再使用了，好吧，先就这样吧。


