alter table paciente add ativo tinyint not null;
update paciente set ativo = 1;