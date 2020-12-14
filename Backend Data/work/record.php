<?php
require_once'connect.php';
if ($_SERVER['REQUEST_METHOD'] =='POST') {
    
    $w_tittle = $_POST['w_tittle'];
    $w_descr = $_POST['w_descr'];
    $w_date = $_POST['w_date'];
    $w_priority = $_POST['w_priority'];

    if ($w_priority == "Low") {
        $image_path = "http://192.168.43.126/work//images/low.png";
        $prio="1";
    }else if ($w_priority == "Medium") {
        $image_path = "http://192.168.43.126/work//images/medium.png";
        $prio="2";
    }else if ($w_priority == "High") {
        $image_path = "http://192.168.43.126/work//images/high.jpg";
        $prio="3";
    }else{
         $image_path = "http://192.168.43.126/work//images/low.png";
         $prio="1";
    }


        

        $sql = "INSERT INTO `work_list`(`tittle`, `descr`,`priority`,`work_date`,`work_image`,`priority_cat`)
        VALUES ('$w_tittle','$w_descr','$w_priority','$w_date','$image_path','$prio') ";

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