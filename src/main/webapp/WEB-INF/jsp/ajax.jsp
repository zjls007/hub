<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html>
<html>
  <head>
    <title>title</title>
    <base href="<%=path%>">
    <script src="static/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
  	<script type="text/javascript">
  		$(function() {
  			$.ajax({
  				async:true,
  				type:'POST',
  				url:'ajax/text',
  				dataType:'text',
  				success:function(data){
  					alert(data);
  				}
  			});
  			
  			$.ajax({
  				async:true,
  				type:'POST',
  				url:'ajax/json',
  				dataType:'json',
  				success:function(data){
  					alert(data);
  				},
  				error:function() {
  					alert('error');
  				}
  			});
  		});
  	</script>
  </head>
  <body>
  	
</body>
</html>
