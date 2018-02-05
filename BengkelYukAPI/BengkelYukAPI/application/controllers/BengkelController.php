<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class BengkelController extends CI_Controller{

    public function __construct(){
        parent::__construct();
        //ini di ambil dulu modelnya, model dibuat untuk mendapatkan data dari database langsung
        $this->load->model('BengkelModel');
    }


    //Controller data bengkel
    public function getAllBengkel(){
        $response = array('Bengkel' => $this->BengkelModel->modelAllBengkel()->result());
        $this->print_json($response);
        exit;
    }
    public function getBengkelDetails($id_bengkel){
        $response =  array('Details' => $this->BengkelModel->modelGetBengkelDetails($id_bengkel)->row_array());
        $this->print_json($response);
        exit;
    }
    //============================

    public function getMerkMotor(){
        $response = array('MerkMotor' => $this->BengkelModel->modelgetMerkMotor()->result());
        $this->print_json($response);
        exit;
    }
    public function getDataMotor($id_merk_motor){
        $response = array('motorlist' => $this->BengkelModel->modelGetDataMotor($id_merk_motor)->result());
        $this->print_json($response);
        exit;
    }

    //=============================

    public function login(){
        $data = (array)json_decode(file_get_contents('php://input'));
        $response = $this->BengkelModel->modelLogin($data);
        if(count($response) > 0){
            $this->print_login_response($response->id_user,true,'Logged in !');
        }else{
            $this->print_response(false,'Wrong Username or Password!');
        }
        exit;
    }

    public function getDataUser($id_user){
        $response =  $this->BengkelModel->modelGetDataUser($id_user)->row_array();
        $this->print_json($response);
        exit;
    }

    public function registerUser(){
        $data = (array)json_decode(file_get_contents('php://input'));
        $is_insert= $this->BengkelModel->modelRegisterUser($data);
        if($is_insert > 0){
            $this->print_response(true,'Success Register Data');
        }
        else{
            $this->print_response(false,'Failed Register Data');
        }
        exit;       
    }
    public function editUser(){
        $data = (array)json_decode(file_get_contents('php://input'));
        $is_edit= $this->BengkelModel->modelEditUser($data);
        if($is_edit > 0){
            $this->print_response(true,'Success Edit Data');
        }
        else{
            $this->print_response(false,'Failed To Edit Data');
        }
        exit;       
    }

    // Controller Booking

    public function getBookingData($id_user){
        $response = array('UserBooking' => $this->BengkelModel->modelGetBookingData($id_user)->result());
        $this->print_json($response);
        exit;
    }
    public function insertBookingData(){
        $data = (array)json_decode(file_get_contents('php://input'));
        $is_insert= $this->BengkelModel->modelInsertBookingData($data);
        if($is_insert > 0){
            $this->print_response(true,'Booking Success');
        }
        else{
            $this->print_response(false,'Booking Failed');
        }
        exit; 
    }
    public function deleteBookingData($id_booking){
        $is_delete= $this->BengkelModel->modelDeleteBookingData($id_booking);
        if($is_delete > 0){
            $this->print_response(true,'Delete Success');
        }
        else{
            $this->print_response(false,'Delete Failed');
        }
        exit; 
    }
    
     /**
        Method print_login_response buat mencetak status login apakah berhasil atau tidak
    **/
    public function print_response($status ,$info){
        $response = array(
            'Success' => $status,
            'Info' => $info);
        $this->print_json($response);
    }
    public function print_login_response($id_user,$status ,$info){
        $response = array(
            'id_user' => $id_user,
            'Success' => $status,
            'Info' => $info);
        $this->print_json($response);
    }
    /**
        Method print_json buat mencetak data berformat JSON.
    **/
    public function print_json($response){
        $this->output
        ->set_status_header(200)
        ->set_content_type('application/json', 'utf-8')
        ->set_output(json_encode($response, JSON_PRETTY_PRINT))
        ->_display();
    }
}