/**
 *
 * Created by liqiang on 2017/10/1.
 */
$(function () {
    /**
     * 提交按钮点击事件，内容不为空 的时候打开模态框输入姓名
     */
    $("#tijiao").click(function () {
        if($("#liuyan").val().length!=0){
            $("#tijiaomotai").modal();
        }else{
            alert("内容不能为空");
        }

    });



});