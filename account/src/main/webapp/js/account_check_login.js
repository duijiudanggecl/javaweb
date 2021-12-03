/**
 * 
 */

 //(1)检测名字
$(function(){
    $('#Name').blur(function(){
    	//1:判断邮箱是否为空
    	$("#warning_Name").html('');
	    var Name = $('#Name').val();
	    if(Name==""){
	    	$("#warning_Name").html('名字不能为空');
	        return;
        }
	    
	    //2:判断邮箱格式是否正确
	  //  var Email_reg=/^[a-zA-Z0-9_+.-]+\@([a-zA-Z0-9-]+\.)+[a-zA-Z0-9]{2,4}$/;
	 //   if(!Email_reg.test(email)){
	  //  	$("#warning_email").html('邮箱格式不正确');
	  //      return;
	  //  }
	    
	    //3:判断邮箱唯一性--Ajax
	    $.ajax({
	        type:"post",
	    	url: 'validName.do',
	        data:{'Name':Name},
	        dataType:"json",
	        success: function(data){ //data:返回JSON数据
	        	$("#warning_Name").html(data.msg);
	        	email_flag = data.status==1? true:false;
	        }
	    });       
    }).focus(function(){
    	$('#Name').val("");
    	$("#warning_Name").html("");
    })
});