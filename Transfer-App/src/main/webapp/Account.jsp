<!DOCTYPE html>
<%@ page import="java.util.*,com.example.entity.Account" %>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- CSS only -->
        <link rel="stylesheet" href="index.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        
        <title>Document</title>
    </head>

    <body class="containerss">
    <div class="title">TRANSACTION -WEB-APP</div>
        <% List<Account> listOfHistory = (List<Account>)request.getAttribute("history-lis");
            %>

            <table class = "table">
                <thead>
                    <tr>
                        
                        <th style ="colour:red;">Account Number</th>
                       
                        <th>balance</th>
                    </tr>
                </thead>
                <tbody>
                    <% for(Account history : listOfHistory){ %>
                        <tr>
                            
                            <td><%=history.getNumber()%></td>
                           
                            <td><%=history.getBalance()%></td>
                        </tr>
                    <% } %>
                </tbody>

            </table>

    </body>

    </html>