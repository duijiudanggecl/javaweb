/**
 * 
 */

 //(1)�������
$(function(){
    $('#Name').blur(function(){
    	//1:�ж������Ƿ�Ϊ��
    	$("#warning_Name").html('');
	    var Name = $('#Name').val();
	    if(Name==""){
	    	$("#warning_Name").html('���ֲ���Ϊ��');
	        return;
        }
	    
	    //2:�ж������ʽ�Ƿ���ȷ
	  //  var Email_reg=/^[a-zA-Z0-9_+.-]+\@([a-zA-Z0-9-]+\.)+[a-zA-Z0-9]{2,4}$/;
	 //   if(!Email_reg.test(email)){
	  //  	$("#warning_email").html('�����ʽ����ȷ');
	  //      return;
	  //  }
	    
	    //3:�ж�����Ψһ��--Ajax
	    $.ajax({
	        type:"post",
	    	url: 'validName.do',
	        data:{'Name':Name},
	        dataType:"json",
	        success: function(data){ //data:����JSON����
	        	$("#warning_Name").html(data.msg);
	        	email_flag = data.status==1? true:false;
	        }
	    });       
    }).focus(function(){
    	$('#Name').val("");
    	$("#warning_Name").html("");
    })
});