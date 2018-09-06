<#macro myLayout>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="Kanban">
    <meta name="author" content="Walter">

    <title>Check List</title>


</head>

<body>

<div class="container">

    <#include "header.ftl"/>

    <div class="panel panel-default">
    <#nested/>
    </div>

    <#include "footer.ftl"/>

</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="./js/vendor/ie10-viewport-bug-workaround.js"></script>
</body>
</html>

</#macro>