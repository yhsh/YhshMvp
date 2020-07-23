package com.xiayiye.yhshmvp.ui.activity

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.xiayiye.yhshmvp.base.MvpBaseActivity
import com.xiayiye.yhshmvp.ui.mvp.presenter.PagePresenter
import com.xiayiye.yhshmvp.ui.mvp.view.PageView
import com.xiayiye.yhshmvp.R

/*
 * Copyright (c) 2020, smuyyh@gmail.com All Rights Reserved.
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG            #
 * #                                                   #
 */

/**
 * @author 下一页5（轻飞扬）
 * 创建时间：2020/4/4 16:30
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：yhshmvp
 * 文件包名：com.xiayiye.yhshmvp.activity
 * 文件说明：MVP框架首页
 */
class MvpPageActivity : MvpBaseActivity<PageView, PagePresenter>(), PageView {
    /**
     * 使用静态方法跳转Activity
     */
    companion object {
        fun start(context: Context) {
            val intent = Intent(context, MvpPageActivity::class.java)
            context.startActivity(intent)
        }
    }

    private lateinit var btTest: Button;
    private lateinit var tvResult: TextView;
    override fun init() {
        btTest = findViewById<Button>(R.id.bt_test)
        tvResult = findViewById<TextView>(R.id.tv_result)
        btTest.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                getPresenter()?.showData("测试数据成功了")
                //跳转Java的Activity页面
                startActivity(Intent(this@MvpPageActivity, JavaActivity::class.java))
            }

        })
    }

    override fun initData() {

    }

    override fun getLayoutId(): Int = R.layout.activity_mvp_page

    override fun createPresenter(): PagePresenter? = PagePresenter()

    override fun <T> setData(data: T) {
        tvResult.text = data as String
    }

    override fun setError(msg: String) {

    }
}