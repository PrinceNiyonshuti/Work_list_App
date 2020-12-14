<?php
require_once'connect.php';
if ($_SERVER['REQUEST_METHOD'] =='POST') {
    
    $w_tittle = $_POST['w_tittle'];
    $w_descr = $_POST['w_descr'];
    $w_date = $_POST['w_date'];
        

        $sql = "INSERT INTO `work_list`(`tittle`, `descr`, `work_date`)
        VALUES ('$w_tittle','$w_descr','$w_date') ";

        if (mysqli_query($conn, $sql)) {

            $result['Success'] = "1";
            $result['message'] = "success";
            echo json_encode($result);
            mysqli_close($conn);

        } else {

            $result['Success'] = "0";
            $result['message'] = "error";

            echo json_encode($result);
            mysqli_close($conn);

        }
    }
?>