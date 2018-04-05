    <html>  
      <head>  
            <title>freemarker测试</title>  
        </head>  
        <body>         
            <#list as www>
				${www.name!}
				${www.password!}
				${www.sex!}
				${www.photo!}
			</#list> 
        </body>  
    </html>  