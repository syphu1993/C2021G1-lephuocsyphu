package customer.model.service.impl;

import customer.model.bean.Customer;
import customer.model.repository.CustomerRepository;
import customer.model.service.ICustomer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerImpl implements ICustomer {
    CustomerRepository customerRepository  = new CustomerRepository();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public Map<String,String> save(Customer customer) {
        List<Customer> listCustomer = customerRepository.findAll();
        boolean flag = true;
        Map<String,String> mapMesg = new HashMap<>();
        if ("".equals(customer.getCode())){
            mapMesg.put("CodeCustomer","Input code, please!");
            flag = false;
        } else if (!customer.getCode().matches("^KH-[\\d]{4}$")){
            mapMesg.put("CodeCustomer","Is not format");
            flag = false;
        }
        else if (customer.getCode().matches("^KH-[\\d]{4}$")){
            for (Customer c:listCustomer) {
                if (c.getCode().equals(customer.getCode())){
                    mapMesg.put("CodeCustomer","Code is exsist");
                    flag = false;
                    break;
                }
            }
        }
        if ("".equals(customer.getPhone())){
            mapMesg.put("phone","Input number phone, please!");
            flag = false;
        } else if (!customer.getPhone().matches("^((\\(84\\)\\+90)|(\\(84\\)\\+91)|(090)|(091))[\\d]{7}$")){
            mapMesg.put("phone","Is not format");
            flag = false;
        }
        else if (customer.getPhone().matches("^((\\(84\\)\\+90)|(\\(84\\)\\+91)|(090)|(091))[\\d]{7}$")){
            for (Customer c:listCustomer) {
                if (c.getPhone().equals(customer.getPhone())){
                    mapMesg.put("phone","Numberphone is exsist");
                    flag = false;
                    break;
                }
            }
        }
        if ("".equals(customer.getIdCard())){
            mapMesg.put("card","Input Id Card, please!");
            flag = false;
        } else if (!customer.getIdCard().matches("^(([\\d]{9})|([\\d]{12}))$")){
            mapMesg.put("card","Is not format");
            flag = false;
        }
        else if (customer.getIdCard().matches("^(([\\d]{9})|([\\d]{12}))$")){
            for (Customer c:listCustomer) {
                if (c.getIdCard().equals(customer.getIdCard())){
                    mapMesg.put("card","ID Card is exsist");
                    flag = false;
                    break;
                }
            }
        }
        if ("".equals(customer.getIdCard())){
            mapMesg.put("email","Input email, please!");
            flag = false;
        } else if (!customer.getIdCard().matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)+$")){
            mapMesg.put("email","Is not format");
            flag = false;
        }
        else if (customer.getIdCard().matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)+$")){
            for (Customer c:listCustomer) {
                if (c.getIdCard().equals(customer.getIdCard())){
                    mapMesg.put("email","Email is exsist");
                    flag = false;
                    break;
                }
            }
        }
        if (flag){
            customerRepository.save(customer);
        }
        return  mapMesg;
    }

    @Override
    public boolean update(Customer customer) {
        return customerRepository.update(customer);
    }

    @Override
    public boolean delete(int id) {
        return customerRepository.delete(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public List<String> findAllTypeCustomer() {
        return customerRepository.findAllTypeCustomer();
    }

}
