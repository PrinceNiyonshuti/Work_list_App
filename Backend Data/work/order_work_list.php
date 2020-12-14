<?php   
    require_once'connect.php';
    if ($_SERVER['REQUEST_METHOD'] =='GET') {

        $result=$conn->query(" SELECT * FROM `work_list` ORDER BY priority_cat DESC "); 
        $json_response = array(); 

       
        while ($row = $result->fetch_assoc()) {

        $row_array['tittle'] = $row['tittle'];  
        $row_array['descr'] = $row['descr'];  
        $row_array['priority'] = $row['priority']; 
        $row_array['work_image'] = $row['work_image']; 
        $row_array['work_date'] = $row['work_date'];  

        array_push($json_response,$row_array);  
        }  
        
        echo json_encode($json_response);

    }  
?>  


