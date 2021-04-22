<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" type="text/css" href="/resources/datatable/datatables.css"/>
<script src="/resources/datatable/datatables.js"></script>
</head>
<body>
<script>
var draw = 1;
$(document).ready(function(){
	$('#example').DataTable({
		processing : true,
		serverSide : true,
		columns : [
			{'data' : 'boNum'},
			{'data' : 'boTitle'},
			{'data' : 'boContent'},		
		],
		fnServerData : function (sSource, orgP, fnCallBack){
			console.log(orgP[1]);
			console.log(orgP[2]);
			console.log(orgP[1])
			var sort = orgP[1]['value'][orgP[2]['value'][0]['column']].data + ',' + orgP[2]['value'][0]['dir'];
            var params = [
               {name : "page", value: (orgP[3].value/orgP[4].value)},
               {name : "size", value: orgP[4].value},
               {name : "sort", value: sort}
               
            ]
			$.getJSON('/boards',params, function(json){
				console.log(json);
				json.draw = ++draw;
				fnCallBack(json)
			});
		}
	})
});
</script>  
   <table id="example" class="display" style="width:70%">
      <thead>
      <tr>
         <th>boNum</th>
         <th>boTitle</th>
         <th>boContent</th>
      </tr>
      </thead>
      <tbody id="tBody">
      </tbody>
   </table>
<script>/* 
   window.onload = function(){
      var xhr = new XMLHttpRequest();
      xhr.open('GET','/boards?size=5&sort=boNum,desc&page=10')
      xhr.onreadystatechange = function(){
         if(xhr.readyState==4 && xhr.status==200){
            var res = JSON.parse(xhr.responseText);
            var html = '';
            for(var board of res.content){
               html += '<tr>';
               html += '<td>' + board.boNum + '</td>';
               html += '<td>' + board.boTitle + '</td>';
               html += '</tr>';
            }
            document.querySelector('#tBody').innerHTML =html;
         }
      }
      xhr.send();
   } */

</script>   
</body>
</html>