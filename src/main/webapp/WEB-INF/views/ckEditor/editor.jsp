<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>CKEditor</title>
<script
	src="https://cdn.ckeditor.com/ckeditor5/27.0.0/classic/ckeditor.js"></script>
</head>
<body>
<div id="editor">This is some sample content.</div>
<button onclick="save()">등록</button>
<script>
var editor;
ClassicEditor
.create( document.querySelector( '#editor' ),{
	ckfinder : {
		uploadUrl : '/upload/image'
	}
} )
.then( obj => {
		editor = obj;
} )
.catch( error => {
	      console.error( error );} );
	      function save(){
	    	  console.log(editor.getData());
	      }
                </script>
</body>
</html>
</html>