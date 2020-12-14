<?php
require_once'connect.php';
if ($_SERVER['REQUEST_METHOD'] =='GET') {
    
    //$UserTel = $_POST['UserTel'];    

    $query=$conn->query(" SELECT * FROM work_list  ");
    $result = array();
    $result['login'] = array();
    if($query->num_rows >= 1){

        $sql_task_data=" SELECT * FROM work_list  ";
        $result_task_data=$conn->query($sql_task_data);
            while ($row_task_data = $result_task_data->fetch_assoc()) {
            $tittle = $row_task_data['tittle'];
            $descr = $row_task_data['descr'];
            $priority = $row_task_data['priority'];
            
            $index['tittle'] = $tittle;
            $index['descr'] = $descr;
            $index['priority'] = $priority;
    
            array_push($result['login'], $index);
    
            $result['success'] = "1";
            $result['message'] = "success";
            echo json_encode($result);
            mysqli_close($conn);
        }
        
    }
    else
    {
        $result['success'] = "2";
        $result['message'] = "No User Found ";

        echo json_encode($result);
        mysqli_close($conn);

        echo '<script language="javascript">
            alert(" User Doesnt Exist ");
            window.location.href = "index.php";
        </script>';
    }
}

?>