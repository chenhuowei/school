<html>
<body>
  <%  
        String path = request.getContextPath();  
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
   %> 
<meta http-equiv="refresh" content="0; <%=basePath %>/common/loginIndex.do" />  



</body>
</html>
