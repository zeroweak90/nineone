
package com.example.demo.controller;

import com.example.demo.mysql.entity.MysqlMember;
import com.example.demo.oracle.entity.OracleMember;
import com.example.demo.mysql.repository.MysqlMemberRepository;
import com.example.demo.oracle.repository.OracleMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/view")
public class MemberController {

    @Autowired
    private MysqlMemberRepository mysqlRepo;

    @Autowired
    private OracleMemberRepository oracleRepo;

    @GetMapping("/api/mysql")
    @ResponseBody
    public List<MysqlMember> getMysqlMembers() {
        return mysqlRepo.findAll();
    }

    @GetMapping("/api/oracle")
    @ResponseBody
    public List<OracleMember> getOracleMembers() {
        return oracleRepo.findAll();
    }

    @GetMapping("/mysql")
    public String mysqlView(Model model) {
        model.addAttribute("mysqlMembers", mysqlRepo.findAll());
        return "mysql";
    }

    @PostMapping("/mysql/add")
    public String addMysqlMember(@RequestParam String name) {
        MysqlMember member = new MysqlMember();
        member.setName(name);
        mysqlRepo.save(member);
        return "redirect:/view/mysql";
    }

    @GetMapping("/mysql/edit/{id}")
    public String editMysqlMemberForm(@PathVariable Long id, Model model) {
        MysqlMember member = mysqlRepo.findById(id).orElseThrow();
        model.addAttribute("member", member);
        return "mysql-edit";
    }

    @PostMapping("/mysql/edit/{id}")
    public String updateMysqlMember(@PathVariable Long id, @RequestParam String name) {
        MysqlMember member = mysqlRepo.findById(id).orElseThrow();
        member.setName(name);
        mysqlRepo.save(member);
        return "redirect:/view/mysql";
    }

    @PostMapping("/mysql/delete/{id}")
    public String deleteMysqlMember(@PathVariable Long id) {
        mysqlRepo.deleteById(id);
        return "redirect:/view/mysql";
    }

    @GetMapping("/oracle")
    public String oracleView(Model model) {
        model.addAttribute("oracleMembers", oracleRepo.findAll());
        return "oracle";
    }

    @PostMapping("/oracle/add")
    public String addOracleMember(@RequestParam String name) {
        OracleMember member = new OracleMember();
        member.setName(name);
        oracleRepo.save(member);
        return "redirect:/view/oracle";
    }

    @GetMapping("/oracle/edit/{id}")
    public String editOracleMemberForm(@PathVariable Long id, Model model) {
        OracleMember member = oracleRepo.findById(id).orElseThrow();
        model.addAttribute("member", member);
        return "oracle-edit";
    }

    @PostMapping("/oracle/edit/{id}")
    public String updateOracleMember(@PathVariable Long id, @RequestParam String name) {
        OracleMember member = oracleRepo.findById(id).orElseThrow();
        member.setName(name);
        oracleRepo.save(member);
        return "redirect:/view/oracle";
    }

    @PostMapping("/oracle/delete/{id}")
    public String deleteOracleMember(@PathVariable Long id) {
        oracleRepo.deleteById(id);
        return "redirect:/view/oracle";
    }
}
