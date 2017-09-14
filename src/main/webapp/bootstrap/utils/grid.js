// a grid function for bootstrap
// a user grid demo
/**
 var attrs = ['schoolYear','term','subjectCode','subjectName','teacherName',
	            'locationName','startTime','endTime','classTime','classWeek',
	            'capacity','catagory'];
	var headers = ['学年','学期','科目代码',
	            '科目名称','教师名称','上课地点','开始时间','结束时间',
	            '上课时间','上课星期','容量','科目类型'];
	var title = '选课信息列表';
	var saveBtn = {'funName':'saveSelect','params':'id','class':'btn-primary','display':'选择'}
	var btns = [saveBtn];
	
	var grid = new Grid('selectOk',title,headers,attrs,btns);
	function loadSelectData(pageNum){
		$.ajax({
			type:'get',
			url:basePath+'student/getSelectSubject.do',
			data:{'page':pageNum,'limit':2},
			success:function(data){
				grid.datas = data;
				grid.loadFun = loadSelectData;
				grid.renderData();
			},
			error:function(){
				alert('请求异常,请稍后再次尝试...')
			}
		})
	}
	
	function saveSelect(id){
		alert(id);
	}
	
	
 */

// grid  method
function Grid(tableId,title,headerArray,attributeArray,btns){
		this.datas;
		this.loadFun;
		var gridId = '#'+tableId;
		var headerId = tableId+'Header';
		var tbodyId = tableId+'Tbody'
		$(gridId).append(
					'<caption><h3 align="center">'+title+'</h3></caption>'+
					'<thead><tr id="'+headerId+'">'+
					'</thead></tr>'
		);
		for(var i=0;i<headerArray.length;i++){
			$('#'+headerId).append(
				'<th>'+headerArray[i]+'</th>'		
			);
		}
		$(gridId).append(
			'<tbody id="'+tbodyId+'"></tbody>'		
		);
		this.renderData = function(){
			if (typeof(this.datas) != 'undefined' && this.datas != null){
				$('#'+tbodyId).children().remove();
				var data = this.datas.rows;
				for(var i=0;i<data.length;i++){
					var td = '';
					for(var j=0;j<attributeArray.length;j++){
						if (data[i][attributeArray[j]] != null){
							if (typeof(data[i][attributeArray[j]]) != 'boolean'){
								td = td + '<td>'+data[i][attributeArray[j]]+'</td>';
							}else{
								td = td + '<td>'+(data[i][attributeArray[j]]==true?'是':'否')+'</td>';
							}
						}else{
							td = td + '<td></td>';
						}
					}
					if (isNotBlank(btns)){
						// add button
						for(var j=0;j<btns.length;j++){
							var paramIndex = btns[j]['params'].split(',');
							var params = '(';
							for(var p=0;p<paramIndex.length;p++){
								if (p < paramIndex.length-1){
									params = params +"'"+ (data[i][paramIndex[p]]) +"'"+',';
								}else{
									params = params +"'"+ (data[i][paramIndex[p]]) +"'"+ ')' ;
								}
							}
							td = td + '<td><button class="btn '+btns[j]['class']+
								'" onclick="'+btns[j]['funName']+params+
							'" id="'+btns[j]['id']+'">'+btns[j]['display']+'</button></td>';
							
						}
					}
					$('#'+tbodyId).append(
							'<tr>'+td+'</tr>'
					);
			}
		}
			// pagination 
			$('#'+tableId+'Page').remove();
			
			$(gridId).after(
					'<form role="form" id="'+tableId+'Page'+'"></form>'
			);
			paginationFun(tableId+'Page',this.datas.pageNum,
					this.datas.pages,this.datas.total,this.loadFun);
		}
	}
	
	function isNotBlank(obj){
		if (typeof(obj) != 'undefined' && null != obj && '' != obj){
			return true;
		}
		return false;
	}
	// pagination function
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
	
	
	
	
	
	