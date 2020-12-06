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
    $headers[] = 'Authorization: key ='.$apiKey;
    $headers[] = 'Content-Type: application/json';
    curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
    
    $result = curl_exec($ch);
    if (curl_errno($ch)) {
        echo 'Error:' . curl_error($ch);
    }
    curl_close($ch);
}

//tujuandata dikirim
// $to = 'cRPglWiFSv24Nt3mSt_hkx:APA91bHKSPrCHtxU5hxvPRlEr9hkS0tv4HP-LJAle1QPsLqF-SlACSnrW8mdvBjLgwDixYbLCKYTL5yi724auBzmzG6xc4U7Z8NQf_wCFh3ZQ3Ty9BzPBF8G9I-xO50U3roZGSwJwhqO';
$to = '/topics/trading';
//data notif yang dikirim
$notif = array(
    'title'=> 'Ada Yang Berubah Nih',
    'body' => 'Buruan Buka Apps Nya'
);

sendNotif($to, $notif);

?>