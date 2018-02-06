#include <stdio.h>
#include <stdlib.h>

typedef char* string;
typedef struct employee {
    string lastname;
    string firstname;
    short age;
    struct employee *minion;
} employee;

typedef employee* list;

void add_item(list employees, employee *blue) {
    while (employees->minion != NULL) {
        employees = employees->minion;
    }
    employees->minion = blue;
}

employee* create_employee(string firstname, string lastname, short age) {
    employee* e = (employee*) malloc(sizeof(employee));
    e->lastname = lastname;
    e->firstname = firstname;
    e->age = age;
    e->minion = NULL;
    return e;
}

void create_add_employee(list employees, string firstname, string lastname, short age) {
    employee* e = create_employee(firstname, lastname, age);
    add_item(employees, e);
}

employee* get_employee(list employees, unsigned int index) {
    // faire une boucle sur la liste plutot ... ce n'est pas un tableau
    //return &employees[index];
}

void print_employee(list e) {
    printf("%s %s age : %d | minion : %s\n", e->firstname, e->lastname, e->age, (e->minion != NULL ? "OUI" : "NON"));
}

void print_employees(list employees) {
    printf("affichage de tous les employees\n");
    while (employees != NULL) {
        print_employee(employees);
        employees = employees->minion;
    }
}

int main() {
    printf("création de master\n");
    employee* master = create_employee("jean", "dubouc", 53);
    list employees = master;
    print_employee(master);
    print_employees(employees);
    printf("ajout de trois minions\n");
    employee* joe = create_employee("joe", "dutronc", 52);
    employee* jack = create_employee("jack", "dutronc", 52);
    add_item(employees, joe);
    add_item(employees, jack);
    // create add employee bug, incompréhensible
    create_add_employee(employees, "alber", "ducon", 20);
    printf("print de master\n");
    print_employee(employees);
    print_employees(employees);
    printf("print de l'employee 2 (joe)\n");
    print_employee(get_employee(employees, 1));
    return 0;
}