//use form and make a id in this which is only one in use

function paginationFun(showId,pageNum,pages,totalRecord,loadFunction){
		$('#'+showId).children().remove();
		var inputId = showId+'Go';
		$('#'+showId).append(
			//'<form role="form" id="paginationForm">'+
		 		'<fieldset>'+
	       		 '<div class="form-group">'+	
						'<div class="col-sm-3">'+
		               		'<h5>当前页码:<strong>'+pageNum+'</strong>,总页数:<strong>'+pages+'</strong>,总记录数:<strong>'+totalRecord+'</strong></h5>'+
		               	'</div>'+	
						'<div class="col-sm-1">'+
		               		'<button type="button" onclick="paginationFirst('+pageNum+','+loadFunction+')" class="btn btn-default">首页</button>'+
		               	'</div>'+	
						'<div class="col-sm-1">'+
		               		'<button type="button" onclick="paginationPrevious('+pageNum+','+loadFunction+')" class="btn btn-default">&laquo; 上页</button>'+
		               	'</div>'+	
						'<div class="col-sm-1">'+
		               		'<button type="button" onclick="paginationNext('+pageNum+','+pages+','+loadFunction+')" class="btn btn-default">下页  &raquo;</button>'+
		               	'</div>'+	
						'<div class="col-sm-1">'+
		               		'<button type="button" onclick="paginationLast('+pageNum+','+pages+','+loadFunction+')" class="btn btn-default">尾页</button>'+
		               	'</div>'+	
						'<div class="col-sm-1">'+
		               		'<h4>转至</h4>'+
		               	'</div>'+	
						'<div class="col-sm-1">'+
		               		'<input type="text" style="width:60px" class="form-control" value="'+pageNum+'" id="'+inputId+'" placeholder="页码">'+
		               	'</div>'+	
						'<div class="col-sm-1">'+
		               		'<button type="button" onclick="paginationGo('+pageNum+','+pages+','+loadFunction+','+"'"+inputId+"'"+')" class="btn btn-default">Go</button>'+
		               	'</div>'+	
				  '</div>'+
		        '</fieldset>'
			//'</form>'
		);
		
	}
	
	function paginationFirst(pageNum,loadFunction){
		if (pageNum == 1 || pageNum == '1'){
			return;
		}
		pageNum = 1;
		loadFunction(pageNum);
	}
	
	function paginationLast(pageNum,pages,loadFunction){
		if (pageNum == pages){
			return;
		}
		pageNum = pages;
		loadFunction(pageNum);
	}
	
	function paginationPrevious(pageNum,loadFunction){
		if (pageNum == 1 || pageNum == '1'){
			return;
		}
		pageNum = pageNum - 1;
		loadFunction(pageNum);
	}
	
	function paginationNext(pageNum,pages,loadFunction){
		if (pageNum == pages){
			return;
		}
		pageNum = pageNum + 1;
		loadFunction(pageNum);
	}
	
	function paginationGo(pageNum,pages,loadFunction,inputId){
		var page = $('#'+inputId).val();
		if (null != page && '' != page){
			if (page<1 || page >pages){
				alert('输入不合法!!!');
			}else if(page != pageNum){
				pageNum = page;
				loadFunction(pageNum);
			}
		}else{
			alert('已经是本页!!!');
		}
	}
	
	
	