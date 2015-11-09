<!DOCTYPE html>
<html lang="en">
<head>
    <script type="text/javascript" src="../../static/js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#removeFromArrayButton').click(function ()
            {
                $.ajax({
                    type: "get",
                    data : ({
                        array: $('#arrayInput').val(),
                        appearance: $('#appearance').val(),
                        isDeleteInRow: $('#isDeleteInRow').is(":checked")
                    }),
                    url: "removeFromList",
                    success: function(result){
                        $("#arrayResult").text(result);
                    }
                });
            });

        });

        $(document).ready(function() {
            $('#calculateHeightButton').click(function ()
            {
                $.ajax({
                    type: "get",
                    data : ({
                        array: $('#arrayInputTree').val()
                    }),
                    url: "calculateTreeHeight",
                    success: function(result){
                        $("#treeHeightResult").text(result);
                    }
                });
            });

        });
    </script>
</head>
<body>
    <table cellspacing="300">
        <tr>
            <td>
                Remove from list test.<br><br>
                Please input numbers separated by commas:
                <input type="text" id="arrayInput">
                <br>
                Appearance to delete (3 by default): <input type="text" id="appearance" size="5">
                <br>
                <label><input type="checkbox" id="isDeleteInRow">Delete in row</label><br>
                <input type="button" id="removeFromArrayButton" value="Remove"><br><br>
                Processed list: <div id="arrayResult"></div>
            </td>
            <td>
                Tree height test.<br><br>
                Please input numbers separated by commas:
                <input type="text" id="arrayInputTree">
                <br>
                <input type="button" id="calculateHeightButton" value="Calculate"><br><br>
                Calculated height: <div id="treeHeightResult"></div>
            </td>
        </tr>
    </table>
</body>

</html>