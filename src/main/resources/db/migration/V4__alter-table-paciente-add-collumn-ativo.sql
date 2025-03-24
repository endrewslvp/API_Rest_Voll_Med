alter table medico add ativo tinyint not null;
update medico set ativo = 1;