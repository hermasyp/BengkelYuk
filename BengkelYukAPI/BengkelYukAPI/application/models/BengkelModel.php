<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');


class BengkelModel extends CI_Model {

    //=========================================
    //Data Bengkel Model

    public function modelAllBengkel(){
        return $this->db->get('tb_data_bengkel');
    }
    public function modelGetBengkelDetails($id_bengkel){
        return $this->db->get_where('tb_data_bengkel',array('id_bengkel' => $id_bengkel));
    }
    //=========================================
    //Data Motor Model
    public function modelgetMerkMotor(){
        return $this->db->get('tb_merk_motor');   
    }
    public function modelGetDataMotor($id_merk_motor){
        $this->db->select('tm.id_tipe_motor,mm.nama_merk,tm.nama_tipe');
        $this->db->from('tb_tipe_motor as tm');
        $this->db->join('tb_merk_motor as mm ','tm.id_merk_motor = mm.id_merk_motor','inner');
        $this->db->where('tm.id_merk_motor',$id_merk_motor);
        return $this->db->get();
    }
    //=========================================
    //User Model
    public function modelGetDataUser($id_user){
        $this->db->select('id_user,nama_user,email,alamat,no_telp');
        $this->db->from('tb_user');
        $this->db->where('id_user',$id_user);
        return $this->db->get();
    }
    public function modelRegisterUser($data){
        $val = array(
            'nama_user' => $data['nama_user'],
            'email' => $data['email'],
            'alamat' => $data['alamat'],
            'no_telp' => $data['no_telp'],
            'password' => $data['password']);
        return $this->db->insert('tb_user', $val);
    }

    public function modelEditUser($data){
        $id_user = $data['id_user'];
        $val = array(
            'nama_user' => $data['nama_user'],
            'email' => $data['email'],
            'alamat' => $data['alamat'],
            'no_telp' => $data['no_telp'],
            'password' => $data['password']);
        $this->db->where('id_user', $id_user);
        return $this->db->update('tb_user', $data);
    }

    public function modelLogin($data){
        $val = array(
            'email' => $data['email'],
            'password' => $data['password']);
        return $result = $this->db->get_where('tb_user',$val)->row();
        /*
        if(count($result)>0){
            return true;
        }else{
            return false;
        }
        */
    }
    //=========================================
    //Model data Booking

    public function modelGetBookingData($id_user){
        $this->db->select('id_booking,u.nama_user,dbe.nama_bengkel,tm.nama_tipe,plat_no,tanggal_service,keluhan,status_checked');
        $this->db->from('tb_data_booking as dbo');
        $this->db->join('tb_data_bengkel as dbe','dbo.id_bengkel = dbe.id_bengkel','inner');
        $this->db->join('tb_user AS u','dbo.id_user = u.id_user','inner');
        $this->db->join('tb_tipe_motor AS tm','dbo.id_tipe_motor = tm.id_tipe_motor','inner');
        $this->db->where('dbo.id_user',$id_user);
        return $this->db->get();
   }
    public function modelInsertBookingData($data){
        $val = array(
            'id_user' => $data['id_user'],
            'id_bengkel' => $data['id_bengkel'],
            'id_tipe_motor' => $data['id_tipe_motor'],
            'plat_no' => $data['plat_no'],
            'tanggal_service' => $data['tanggal_service'],
            'keluhan' => $data['keluhan'],
            'status_checked' => $data['status_checked']);
        return $this->db->insert('tb_data_booking', $val);        
    }
    public function modelDeleteBookingData($id_booking){
        $this->db->where('id_booking', $id);
        return $this->db->delete('tb_data_booking');
    }

}

