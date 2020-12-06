<?php 

function sendNotif($to, $notif){
    $apiKey = 'AAAAKZtOjJo:APA91bE6lBDVEuL7gj-2NXHZ31Us7_lSf_bXHdBEX7zoBhtJLmsGqqYvi0jVYXIVkx53jSoLMAnzodJBToJqETBxrnOdImzoUVXZ79SpgN-X-M84JP6cFFabaVG24uckU1KZcR4G4-DE';
    $ch = curl_init();
    
    $url = "https://fcm.googleapis.com/fcm/send"; 
    $fields = json_encode(array('to' => $to, 'notification' =>$notif));
    
    curl_setopt($ch, CURLOPT_URL, $url);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
    curl_setopt($ch, CURLOPT_POST, 1);
    curl_setopt($ch, CURLOPT_POSTFIELDS, ($fields));
    
    $headers = array();
    $headers[] = $apiKey;
    $headers[] = 'Content-Type: application/json';
    curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
    
    $result = curl_exec($ch);
    if (curl_errno($ch)) {
        echo 'Error:' . curl_error($ch);
    }
    curl_close($ch);
}

//tujuandata dikirim
// $to = 'djd4obJTSNGe-EXKe0x600:APA91bFkp4A0OCvdL31NdIo0zEyIcwJ00bK_8cOPH3hrlFtfmQ-3wH9Eg1C2P_SAUsJyNCJ0thBFKAu5rRZyfqBxWZf6s-PrLcCrAtLn2XbyMC01xHOSEGAcMYh81Xe1W1CQkCVVae8y';
$to = '/topics/trading';
//data notif yang dikirim
$notif = array(
    'title'=> 'Ada Yang Berubah Nih',
    'body' => 'Buruan Buka Apps Nya'
);

sendNotif($to, $notif);

?>