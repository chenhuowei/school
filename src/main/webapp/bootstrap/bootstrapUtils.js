//@author chenhuowei at 2016/10/07


//auto tips 
function alertTip(showId,isSuccess,msg){
	var html = '';
	if (isSuccess){
		
		 html = '<div id="myAlert" class="alert alert-success">'+
		    '<a href="#" class="close" data-dismiss="alert">&times;</a>'+
		    '<strong>成功！</strong>'+msg+
			'</div>  ';
	}else{
		 html = '<div id="myAlert" class="alert alert-danger">'+
		    '<a href="#" class="close" data-dismiss="alert">&times;</a>'+
		    '<strong>警告！</strong>'+msg+
			'</div>  ';
	}
		$("#"+showId).children().remove();
		$("#"+showId).append(html);
		//auto colse
      
       setTimeout(' $("#myAlert").attr("hidden",true)',5000);//1000为1秒钟
		
}

// rewrite serializeObject by other author
$.fn.serializeObject = function()    
{    
   var o = {};    
   var a = this.serializeArray();    
   $.each(a, function() {    
       if (o[this.name]) {    
           if (!o[this.name].push) {    
               o[this.name] = [o[this.name]];    
           }    
           o[this.name].push(this.value || '');    
       } else {    
           o[this.name] = this.value || '';    
       }    
   });    
   return o;    
}; 


//load json to fill form or other where have input elements by other author
function loadData(formId,jsonStr){
	var obj = eval("("+jsonStr+")");
	var key,value,tagName,type,arr;
	for(x in obj){
		key = x;
		value = obj[x];
		$("#"+formId+" [name='"+key+"'],[name='"+key+"[]']").each(function(){
			tagName = $(this)[0].tagName;
			type = $(this).attr('type');
			if(tagName=='INPUT'){
				if(type=='radio'){
					if (typeof(value) == 'boolean'){
						$(this).attr('checked',true);
					}else{
						$(this).attr('checked',$(this).val()==value);
					}
				}else if(type=='checkbox'){
					arr = value.split(',');
					for(var i =0;i<arr.length;i++){
						if($(this).val()==arr[i]){
							$(this).attr('checked',true);
							break;
						}
					}
				}else{
					$(this).val(value);
				}
			}else if(tagName=='SELECT' || tagName=='TEXTAREA'){
				$(this).val(value);
			}
			
		});
	}
}


//submit form by chenhuowei
function submitForm(formId,url,showId,otherFunction){ 
    var json = $('#'+formId).serializeObject();  
    
    $.ajax({
    	type: 'post',
    	url :basePath+url,
    	data : json,
    	 success: function(msg){  
    		 alertTip(showId,msg.success,msg.message);
    		if (msg.success){
    			if(typeof(otherFunction) == 'function'){
    				otherFunction();
    			}
    		}
    		
		   },
		   error:function(){
			   alert('操作失败，请稍后在执行操作...');
		   }
    	
    	
    })
    
}  

function ajaxFunction(type,url,data,otherFunNeedData){
	$.ajax({
		type:type,
		url: basePath+url,
		data: params,
		success:function(data){
			otherFunNeedData(data);
		},
		error:function(){
			alert('请求异常，请稍后再次尝试...');
		}
	})
}











