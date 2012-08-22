<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="WebForm2.aspx.vb" Inherits="Program_4.WebForm2" %>

<%@ Register Assembly="AjaxControlToolkit" Namespace="AjaxControlToolkit" TagPrefix="cc1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>Untitled Page</title>
    <style type="text/css">
        #TextArea1
        {
            height: 197px;
            text-align: center;
            width: 360px;
        }
        .style9
        {
            width: 23%;
        }
        .style10
        {
            width: 1406px;
        }
        .style11
        {
            width: 25%;
        }
        .style12
        {
            width: 137px;
        }
        .style13
        {
            width: 150px;
        }
        .style14
        {
            width: 25%;
        }
        .style15
        {
            width: 200px;
        }
        .style16
        {
            width: 163px;
        }
        .style17
        {
            width: 2%;
        }
        .style18
        {
            width: 25%;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
    <asp:ScriptManager id="ScriptManager1" runat ="server" />
    <cc1:FilteredTextBoxExtender ID="FilteredTextBoxExtender1" runat="server" TargetControlID ="txtAmount" FilterType ="Custom, Numbers" ValidChars =".">
    </cc1:FilteredTextBoxExtender>
    <div>
    
        <br />
    
        <table align="center" class="style14">
            <tr>
                <td class="style15">
                    <asp:Label ID="Label1" runat="server" Text="Loan Amount"></asp:Label>
                </td>
                <td class="style16">
                    <asp:TextBox ID="txtAmount" runat="server" Width="207px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="style15">
                    <asp:Label ID="Label2" runat="server" Text="Loan Details"></asp:Label>
                </td>
                <td class="style16">
                    <asp:DropDownList ID="cmbLoanInfo" runat="server" Height="16px" 
                        Width="205px">
                        <asp:ListItem>Please select a rate and term</asp:ListItem>
                        <asp:ListItem>7 Years, 5.35%</asp:ListItem>
                        <asp:ListItem>15 Years, 5.5%</asp:ListItem>
                        <asp:ListItem>30 Years, 5.75%</asp:ListItem>
                    </asp:DropDownList>
                </td>
            </tr>
        </table>
        <table align="center" class="style9">
            <tr>
                <td class="style10">
                    <asp:TextBox ID="rtxtDisplay" TextMode="multiline" runat="server" 
                        Height="167px" Width="387px"></asp:TextBox>
                </td>
            </tr>
        </table>
        <table align="center" class="style11">
            <tr>
                <td class="style12">
                    <asp:Button ID="btnCalculate" runat="server" Text="Calculate" Width="100px" />
                </td>
                <td class="style13">
                    <asp:Button ID="btnClear" runat="server" Text="Clear" Width="100px" />
                </td>
            </tr>
        </table>
        <table align="center" class="style18">
            <tr>
                <td>
                    <asp:Chart ID="Chart1" runat="server">
                        <Series>
                            <asp:Series ChartType="Line" Name="Series1">
                            </asp:Series>
                        </Series>
                        <ChartAreas>
                            <asp:ChartArea Name="ChartArea1">
                                <AxisY Title="Principal Amount">
                                </AxisY>
                                <AxisX Title="Term">
                                </AxisX>
                            </asp:ChartArea>
                        </ChartAreas>
                    </asp:Chart>
                </td>
            </tr>
        </table>
        <br />
        <table align="center" class="style17">
            <tr>
                <td>
                    <asp:HyperLink ID="HyperLink1" runat="server" NavigateUrl="~/Default.aspx">Home</asp:HyperLink>
                </td>
            </tr>
        </table>
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
    
    </div>
    </form>
</body>
</html>
