#!/usr/bin/env python3

from random import choice as rc, choices as rcw, randint, randrange, uniform
import random
from datetime import timedelta, datetime
import string


# Generate a random string of charater and digits of a given lenght (default=10)
def random_string(string_length=10):
    letters = string.ascii_lowercase + string.digits
    return ''.join(rc(letters) for i in range(string_length))


# Generate a random string of digits starting with 3(default=10)
def random_phone(string_length=10):
    letters = string.digits
    return '3' + ''.join(rc(letters) for i in range(string_length - 1))


# Generate a random string of digits (default=5)
def random_cap(string_length=5):
    letters = string.digits
    return ''.join(rc(letters) for i in range(string_length))


# Generate a random datetime between two datetime objects.
def random_date(start=datetime.strptime('2018-1-1 7:00:00', '%Y-%m-%d %H:%M:%S'),
                end=datetime.strptime('2019-6-10 21:00:00', '%Y-%m-%d %H:%M:%S')):
    delta = end - start
    int_delta = (delta.days * 24 * 60 * 60) + delta.seconds
    random_second = randrange(int_delta)
    return start + timedelta(seconds=random_second)


# INSERT string base
StrInsert = 'INSERT INTO {table} ( {columns} ) VALUES '
StrValues = " ( {}),"

# ---------------------------------------------------- SOFTWARE --------------------------------------------------------
software = {
    'nome': ("'Stratosphere'", "'Connections'", "'Drivers'", "'GameFan'", "'BestRecording'", "'OfficeManager'",
             "'SuperPhotoEditor'", "'3D Designer'", "'VirusGuardX'"),
    'versione': ("'1.1'", "'2.12.435'", "'0.4.1254'", "'15.98'", "'165.32'", "'76.4.23'"),
    'stato': (
        "'Proposed'", "'Rejected'", "'Approved'", "'In planning'", "'In development'", "'In testing'",
        "'Quality control'", "'Issue'", "'Active'", "'Need view'", "'At risk'", "'Closed'", "'Suspended'"),
    'so': ("'Windows 10'", "'Linux'", "'OsX'", "'Android'", "'IOs'", "'ChromeOS'"),
    'descrizione': ("'Il software per tutte le vostre esigenze.'", "'Un prodotto completo e semplice'",
                    "'Il miglior prodotto valutato da Hardware Upgrade'"),
    'prezzo_listino': ("NULL", "'15'", "'10'", "'3.5'", "'25'", "'40'")
}
StrFinal = StrInsert.format(table='SOFTWARE',
                            columns=[k for k in software.keys()]).replace('[', '').replace(']', '').replace("'", '')

# software_set: unique values of ('indice sw(pk)','prezzo_listino')
software_set = set()
for sw in software['nome']:
    s_tmp = (software['nome'].index(sw) + 1, rc(software['prezzo_listino']))
    software_set.add(s_tmp)
    StrFinal += StrValues.format(
        sw + ',' + rc(software['versione']) + ',' + rc(software['stato']) + ',' + rc(software['so']) + ',' + rc(
            software['descrizione']) + ',' + s_tmp[1])
print(StrFinal[::-1].replace(',', ';', 1)[::-1])

software_pk = len(software['nome'])

# ---------------------------------------------- PERSONA ---------------------------------------------------------------
NUM = 300  # 25  # 300

persona = {
    'cf': 16,
    'nome': (
        "'Mario'", "'Marco'", "'Giorgio'", "'Chiara'", "'Giovanna'", "'Giovanni'", "'Giorgio'", "'Maria'", "'Paola'",
        "'Paolo'", "'Franco'", "'Annamaria'", "'Marianna'", "'Francesco'", "'Francesca'", "'Giulia'", "'Giulio'",
        "'Erica'", "'Andrea'", "'Alberto'", "'Susanna'", "'Angelo'", "'Angela'", "'Lorenzo'", "'Enrico'", "'Daniele'",
        "'Daniela'", "'Diletta'", "'Alessio'", "'Alessia'", "'Massimo'", "'Massimiliano'", "'Vittoria'"),
    'cognome': (
        "'Rossi'", "'Ferrari'", "'Sala'", "'Becco'", "'Innocenti'", "'Bianchi'", "'Milano'", "'Menta'", "'Russo'",
        "'Esposito'", "'Bianchi'", "'Romano'", "'Colombo'", "'Marino'", "'Greco'", "'Botta'", "'Lombardi'", "'Fontana'",
        "'Leone'", "'Gentile'", "'Serra'", "'Monti'"),
    'e_mail': ("gmail.com", "outlook.it", "live.com", "live.it", "libero.com", "unimore.it", "fastmail.fm", "inbox.com",
               "mail.com", "mixmail.com", "yahoo.com", "goowy.com", "aol.com", "lycos.com", "hushmail.com", "hush.com",
               "gmx.com", "facebook.com", "yandex.com", "shortmail.com"),
    'psw': 24,
    'telefono': (),
    'citta': ("'Modena'", "'Bologna'", "'Roma'", "'Livorno'", "'Parma'", "'Torino'"),
    'cap': 5,
    'indirizzo': ("'via Roma'", "'viale Italia'", "'piazza Mazzini'", "'via Bach'", "'via Bernini'", "'viale Verdi'",
                  "'viale Vesuvio'", "'piazza Baglioni'", "'largo Augusto'", "'vicolo Stretto'",
                  "'parco della Vittoria'", "'vicolo Corto'", "'Largo Giulio Cesare'", "'Bastioni Gran Sasso'",
                  "'Viale Monterosa'", "'via Accademia'", "'corso Ateneo'", "'piazza Università'", "'Corso Raffaello'",
                  "'Piazza Dante'", "'via Marco Polo'", "'corso Magellano'", "'largo Colombo'", "'viale Costatino'",
                  "'viale Traiano'", "'corso Impero'", "'viale dei Giardini'"),
    'civico': ()
}

StrFinal = StrInsert.format(table='PERSONA',
                            columns=[k for k in persona.keys()]).replace('[', '').replace(']', '').replace("'", '')

persona_set = set()  # set composed by ('firstname','lastname','email','cf')

# for p in range(NUM):
p = 0
while p < NUM:
    name = (rc(persona['nome']), rc(persona['cognome']), rc(persona['e_mail']))
    cf = "'" + str(name[0][1:4] + name[1][1:4] + random_string()).upper() + "'"
    name = (name[0],  # firstname
            name[1],  # lastname
            "'" + (name[0] + '.' + name[1] + '@' + name[2]).replace("'", '').lower() + "'",  # e-mail
            cf  # codice fiscale
            )
    f = 1
    for el in persona_set:
        if el[0:2] == name[0:2]:
            f = 0
            break
    if f == 1:
        p += 1
        persona_set.add(name)
        StrFinal += StrValues.format(
            name[3] + ',' + name[0] + ',' + name[1] + ',' + name[2] + ",'" + random_string(24) + "','" +
            random_phone() + "'," + rc(persona['citta']) + ",'" + random_cap() + "'," + rc(persona['indirizzo']) +
            ",'" + str(randint(0, 200)) + "'")
print(StrFinal[::-1].replace(',', ';', 1)[::-1])

persona_pk = len(persona_set)

# ---------------------------------------------- M_ASSISTENZA ----------------------------------------------------------
NUM = 50  # 15  # 50

m_a = {
    'data_entrata': (),
    'data_uscita': (),
    'posizione': (),
    'tipo': (
        "'Smartphone'", "'Smartphone'", "'Laptop'", "'Laptop'", "'Laptop'", "'Desktop'", "'Stampante'", "'Monitor'",
        "'Fotocamera'", "'Netbook'", "'Modem'", "'Access Point'"),
    'descrizione': ('NULL', 'NULL'),
    'marca': (
        "'Huawei'", "'Microsoft'", "'Apple'", "'Acer'", "'HP'", "'Dell'", "'IBM'", "'Canon'", "'Samsung'", "'Lenovo'",
        "'Asus'", "'Nikon'", "'D-Link'", "'Netgear'", "'Cisco'", "'Wacom'", "'Sony'", "'Wiko'"),
    'modello': (
        "'Pro 1'", "'Pro Max'", "'W100'", "'600D'", "'K400'", "'Jet3480'", "'6T'", "'D80'", "'Plus'", "'S'", "'Aspire'",
        "'R'", "'Evo'", "'400'", "'KRT'", "'Max'", "'20'", "'Star'", "'Seven'", "'Air'", "'Intus'", "'Galaxy'",
        "'Alfa'", "'Pro 6'", "'Gemini'", "'Bravo'", "'Omega'", "'Charlie'", "'Delta'", "'QL17'")
}
m_a_set = set()  # contains (id,data_in, data_out)
StrFinal = StrInsert.format(table='M_ASSISTENZA',
                            columns=[k for k in m_a.keys()]).replace('[', '').replace(']', '').replace("'", '')
for ma in range(1, NUM + 1):
    d_in = random_date()
    d_out = rc(("'" + str(random_date(start=d_in)) + "'", 'NULL'))
    m_a_key = (ma, d_in, d_out)
    StrFinal += StrValues.format(
        "'" + str(m_a_key[1]) + "'," + str(m_a_key[2]) + ",'" + random_string(6) + "'," + rc(
            m_a['tipo']) + "," + rc(m_a['descrizione']) + "," + rc(m_a['marca']) + "," + rc(m_a['modello']))
    m_a_key = (ma, d_in, str(d_out).replace("'", ''))
    m_a_set.add(m_a_key)
print(StrFinal[::-1].replace(',', ';', 1)[::-1])

m_a_pk = NUM

# ------------------------------------------------- M_VENDITA ----------------------------------------------------------
NUM = 1000  # 20 # 1000
m_v = {
    'marca': m_a,
    'modello': m_a,
    'data': m_a,
    'quantita': 40,
    'posizione': m_a,
    'tipo': m_a,
    'prezzo_listino': 1500.0,
    'descrizione': ("NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL",
                    "'Il miglior dispositivo per ogni tua esigenza'", "'8GB RAM 128GB Memoria Schermo 6.1 pollici'",
                    "'La massima velocità nelle tue mani'")
}
m_v_set = set()  # Contain ('marca','modello','quantita','prezzo')

StrFinal = StrInsert.format(table='M_VENDITA',
                            columns=[k for k in m_v.keys()]).replace('[', '').replace(']', '').replace("'", '')
for mv in range(NUM):
    r1 = randint(40, 120)
    r2 = round(random.uniform(10, 1500), 2)
    m_v_key = (rc(m_a['marca']), rc(m_a['modello']), r1, r2)
    for el in m_v_set:
        if el[0] == m_v_key[0] and el[1] == m_v_key[1]:
            m_v_key = (m_v_key[0], "'" + m_v_key[1].replace("'", "") + '-' + random_string(2).upper() + "'", r1, r2)
    tmp = 0
    for el in m_v_set:
        if el[0] == m_v_key[0] and el[1] == m_v_key[1]:
            tmp = 1
    if tmp == 0:
        m_v_set.add(m_v_key)
        StrFinal += StrValues.format(str(m_v_key[0]) + "," + m_v_key[1] + ",'" + str(random_date()) + "','" +
                                     str(m_v_key[2]) + "','" + random_string(6) + "'," + rc(m_a['tipo']) +
                                     ",'" + str(m_v_key[3]) + "'," + rc(m_v['descrizione']))
print(StrFinal[::-1].replace(',', ';', 1)[::-1])

m_v_pk = len(m_v_set)

# ------------------------------------------------- CLIENTE ------------------------------------------------------------
NUM = int(persona_pk * 4 / 5) - 10  # 80% delle persone -10 persone (per avere almeno 10 dipendenti)
cliente_set = set()
cliente = {
    'cf': (),
    'data_registrazione': (),  # m_a random_date
    'p_iva': (),
    'azienda': (
        "'CalTec'", "'CatCo'", "'Skynet'", "'Umbrella Corporation'", "'Spectre'", "'Guggol'", "'Oracol'",
        "'Maicrosoft'",
        "'Eppol'")
}
azienda_index = -1
StrFinal = StrInsert.format(table='CLIENTE',
                            columns=[k for k in cliente.keys()]).replace('[', '').replace(']', '').replace("'", '')
while len(cliente_set) < NUM:
    p_fk = rc(list(sorted(persona_set)))
    if p_fk not in cliente_set:
        cliente_set.add(p_fk)
        p_iva = str([random_string(11) if randint(1, 100) < 25 else 'NULL']).replace('[', '').replace(']', '')
        if p_iva != "'NULL'":
            azienda = str([cliente['azienda'][azienda_index] if azienda_index < len(cliente['azienda'])
                           else 'NULL']).replace('[', '').replace(']', '').replace('"', '')
            azienda_index += 1
        else:
            p_iva = 'NULL'
            azienda = 'NULL'
        StrFinal += StrValues.format(p_fk[3] + ",'" + str(random_date()) + "'," + p_iva + ',' + azienda)
print(StrFinal[::-1].replace(',', ';', 1)[::-1])

cliente_pk = NUM

# ------------------------------------------------- DIVISIONE ----------------------------------------------------------
divisione = {
    'nome': ("'Software'", "'Hardware'", "'Vendita'", "'Direzione'"),
    'cf': 'NULL'
}

StrFinal = StrInsert.format(table='DIVISIONE',
                            columns=[k for k in divisione.keys()]).replace('[', '').replace(']', '').replace("'", '')
for div in divisione['nome']:
    StrFinal += StrValues.format(div + ',NULL')

print(StrFinal[::-1].replace(',', ';', 1)[::-1])

# ------------------------------------------------- DIPENDENTE ---------------------------------------------------------
NUM = persona_pk - cliente_pk
dipendente_set = set()  # ('firstname','lastname','email','cf','divisione')
dipendente = {
    'cf': (),
    'data_assunzione': (),
    'stipendio': (),
    'leader': (True, False),
    'divisione': ()
}

StrFinal = StrInsert.format(table='DIPENDENTE',
                            columns=[k for k in dipendente.keys()]).replace('[', '').replace(']', '').replace("'", '')
for dip in persona_set.difference(cliente_set):
    div = rc(divisione['nome'])
    dipendente_set.add((dip[0], dip[1], dip[2], dip[3], div))
    StrFinal += StrValues.format(dip[3] + ",'" + str(random_date()) + "','" +
                                 str(round(random.uniform(600, 3000), 2)) + "'," + str(rc(dipendente['leader'])) +
                                 ',' + div)
print(StrFinal[::-1].replace(',', ';', 1)[::-1])

for div in divisione['nome']:
    cf = None
    for dip in dipendente_set:
        if dip[4] == div:
            cf = dip[3]
            break
    st = 'UPDATE DIVISIONE' + " SET cf = " + str(cf) + " WHERE nome = " + div + ';'
    print(st)

dip_software_set = set()  # set of workers in Software department
dip_vendita_set = set()  # set of workers in Sales department
dip_direzione_set = set()  # set of workers in Directors department
dip_hardware_set = set()  # set of workers in Hardware department
for d in dipendente_set:
    if d[4] == "'Software'":
        dip_software_set.add(d)
    elif d[4] == "'Vendita'":
        dip_vendita_set.add(d)
    elif d[4] == "'Direzione'":
        dip_direzione_set.add(d)
    elif d[4] == "'Hardware'":
        dip_hardware_set.add(d)

dipendente_pk = NUM

# ------------------------------------------------- CREA ---------------------------------------------------------------
NUM = software_pk

crea = {
    'id': (),  # software_fk
    'cf': (),  # dipendente_fk
    'data': ()
}
crea_set = set()  # contain ('id','dip','data')

StrFinal = StrInsert.format(table='CREA',
                            columns=[k for k in crea.keys()]).replace('[', '').replace(']', '').replace("'", '')
for i in software_set:
    dip_index = (i[0] - 1) % len(dip_software_set)
    dip = list(sorted(dip_software_set))[dip_index]
    crea_key = (i, dip[3], random_date())
    crea_set.add(crea_key)
    StrFinal += StrValues.format("'" + str(crea_key[0][0]) + "'," + crea_key[1] + ",'" + str(crea_key[2]) + "'")
print(StrFinal[::-1].replace(',', ';', 1)[::-1])

crea_pk = NUM

# ------------------------------------------------- ORDINE -------------------------------------------------------------
NUM = 1000  # 15 # 1000

ordine = {
    'data': (),
    'online': (True, False),
    'dipendente': (),
    'cliente': ()
}

StrFinal = StrInsert.format(table='ORDINE',
                            columns=[k for k in ordine.keys()]).replace('[', '').replace(']', '').replace("'", '')
for o in range(NUM):
    online = rc(ordine['online'])  # to choose if the order is online or in shop
    d = 'NULL'
    c = rc(list(persona_set))[3]
    if not online:
        d = rc(list(dip_vendita_set))[3]
        for c in d:
            c = rc(list(persona_set))[3]

    StrFinal += StrValues.format(
        "'" + str(random_date()) + "'," + str(online) + ',' + d + ',' + c)
print(StrFinal[::-1].replace(',', ';', 1)[::-1])

ordine_pk = NUM

# ------------------------------------------------- DI_H ---------------------------------------------------------------
NUM = ordine_pk

di_h = {
    'ordine': (),
    'marca': (),
    'modello': (),
    'quantita_venduta': (),
    'prezzo_vendita': ()
}

StrFinal = StrInsert.format(table='DI_H',
                            columns=[k for k in di_h.keys()]).replace('[', '').replace(']', '').replace("'", '')
u_o_set = set()
for d in range(NUM):
    o = randint(1, ordine_pk)
    p = rc(list(m_v_set))
    q = randint(1, 10)
    price = round(p[3] + round(random.uniform(-(p[3] - 0.5), 10), 2), 2)

    if (o, p) not in u_o_set:
        u_o_set.add((o, p))
        StrFinal += StrValues.format(
            "'" + str(o) + "'," + p[0] + ',' + p[1] + ",'" + str(q) + "','" + str(round(price, 2)) + "'")
print(StrFinal[::-1].replace(',', ';', 1)[::-1])

# ------------------------------------------------- DI_S ---------------------------------------------------------------
NUM = int(ordine_pk / 2)

di_s = {
    'ordine': (),
    'software': (),
    'quantita_venduta': (),
    'prezzo_vendita': ()
}

StrFinal = StrInsert.format(table='DI_S',
                            columns=[k for k in di_s.keys()]).replace('[', '').replace(']', '').replace("'", '')
u_o_set = set()
for d in range(NUM):
    o = randint(1, ordine_pk)
    s = rc(list(software_set))
    q = randint(1, 10)
    if s[1] != 'NULL':
        p = round(float(str(s[1]).replace("'", '')) + random.uniform(-(float(str(s[1]).replace("'", '')) - 0.5), 10), 2)
        if (o, s) not in u_o_set:
            u_o_set.add((o, s))
            StrFinal += StrValues.format(
                "'" + str(o) + "','" + str(s[0]) + "','" + str(q) + "','" + str(p) + "'")
print(StrFinal[::-1].replace(',', ';', 1)[::-1])
print('DELETE FROM ORDINE WHERE prezzo_totale is NULL;')

# ------------------------------------------------- TICKET -------------------------------------------------------------
ticket = {
    'data': (),
    'stato': ("'On hold'", "'Rejected'", "'Approved'", "'Scheduled'", "'In progress'", "'Completed'"),
    'descrizione': {'Software': ("'Update README.md'", "'Bug fixed on lib/iostream/'", "'Errore in lettura da file'",
                                 "'Modifica alla grafica di visualizzazione'",
                                 "'Miglioramento delle prestazioni nel ciclo parallelo'",),
                    'Hardware': ("'Schermo da sostituire'", "'Aggiornamento firmware'", "'Sostituzione lettore cd'",
                                 "'Upgrade Ram'", "'Sostituione scheda madre'", "'Sostituzione batteria'"),
                    'Vendita': ("'Scaffale portatili da aggiornare'", "'Richiesta sostituzione per cassiere Sabato'",
                                "'Formazione del personale alle vendite'"),
                    'Direzione': ("'Analisi di bilancio mensile'", "'Modifica della gestione dei rischi'",
                                  "'Apertura assunzioni reparto Software'", "'Calo delle prestazioni in assistenza'",
                                  "'Modifica della mission aziendale'", "'Sostituzione del logo'"),
                    },
    'priorita': (1, 9),
    'prezzo': 'NULL',
    'durata_totale': 'NULL',
    'cf': (),
    'id_sw': (),
    'id_hw': (),
    'divisione': ()
}

ticket_set = set()  # contain ('data','status','descrizione','priorita','prezzo','durata','cf','id_s','id_h','divisione')
for p in m_a_set:
    ticket_key = (p[1], rc(ticket['stato']), rc(ticket['descrizione']['Hardware']), randint(1, 9), 'NULL', 'NULL',
                  rc(list(persona_set))[3], 'NULL', p[0], "'Hardware'")
    ticket_set.add(ticket_key)

for p in crea_set:
    ticket_key = (p[2], rc(ticket['stato']), rc(ticket['descrizione']['Software']), randint(1, 9), 'NULL', 'NULL',
                  p[1], p[0][0], 'NULL', "'Software'")
    ticket_set.add(ticket_key)
for p in crea_set:
    ticket_key = (
        random_date(start=p[2], end=p[2] + timedelta(weeks=4)), rc(ticket['stato']),
        rc(ticket['descrizione']['Software']), randint(1, 9), 'NULL', 'NULL', rc(list(dip_software_set))[3], p[0][0],
        'NULL', "'Software'")
    ticket_set.add(ticket_key)

for d in ticket['descrizione']['Vendita']:
    ticket_key = (random_date(), rc(ticket['stato']), d, randint(1, 9), 'NULL', 'NULL', rc(list(dip_vendita_set))[3],
                  'NULL', 'NULL', "'Vendita'")
    ticket_set.add(ticket_key)

for d in ticket['descrizione']['Direzione']:
    ticket_key = (random_date(), rc(ticket['stato']), d, randint(1, 9), 'NULL', 'NULL', rc(list(dip_direzione_set))[3],
                  'NULL', 'NULL', "'Direzione'")
    ticket_set.add(ticket_key)

StrFinal = StrInsert.format(table='TICKET',
                            columns=[k for k in ticket.keys()]).replace('[', '').replace(']', '').replace("'", '')
for t in list(sorted(ticket_set)):
    StrFinal += StrValues.format("'" + str(t[0]) + "'," + t[1] + ',' + t[2] + ",'" + str(t[3]) + "'," + t[4] +
                                 ',' + t[5] + ',' + t[6] + ',' +
                                 str(["'" + str(t[7]) + "'" if t[7] is not 'NULL' else t[7]][0]) + ',' +
                                 str(["'" + str(t[8]) + "'" if t[8] is not 'NULL' else t[8]][0]) + ',' + t[9])
print(StrFinal[::-1].replace(',', ';', 1)[::-1])

ticket_pk = software_pk * 2 + m_a_pk + len(ticket['descrizione']['Vendita']) + len(ticket['descrizione']['Direzione'])

# ------------------------------------------------- IN_CARICO ----------------------------------------------------------
NUM = int(ticket_pk * 4)
in_carico = {
    'cf': 'dipendente',
    'data_inizio': (),
    'data_fine': (),
    'nota': ('NULL',),
    'id': 'ticket'
}

# in_carico_set = set()  # ('cf', 'di','df','nota','id_ticket')
in_carico_set =set()
t = rc(list(ticket_set))
d_list = [x for x in dipendente_set if x[4] == t[9]]
l = len(d_list)
c = 0
test_t = list(sorted(ticket_set)).index(t) + 1
while c < l:
    di = random_date(start=t[0])
    in_carico_key = (d_list[c][3], di, "'" + str(random_date(start=di, end=di + timedelta(days=1))) + "'",
                     rc(in_carico['nota']), list(sorted(ticket_set)).index(t) + 1)
    in_carico_set.add(in_carico_key)
    c += 1
tc=t[:] # --------------------
d = len(in_carico_set)
dc=d # ------------------
while d <= NUM:
    t = rc(list(ticket_set))
    cf = None
    if t[9] == "'Software'":
        cf = rc(list(dip_software_set))
    elif t[9] == "'Vendita'":
        cf = rc(list(dip_vendita_set))
    elif t[9] == "'Direzione'":
        cf = rc(list(dip_direzione_set))
    elif t[9] == "'Hardware'":
        cf = rc(list(dip_hardware_set))

    di = random_date(start=t[0])
    in_carico_key = (cf[3], di, "'" + str(random_date(start=di, end=di + timedelta(days=1))) + "'",
                     rc(in_carico['nota']), list(sorted(ticket_set)).index(t) + 1)

    if len(in_carico_set) == 0:
        in_carico_set.add(in_carico_key)
        d += 1
        continue
    if in_carico_key[2] == 'NULL':
        print("[*] NULL")
        max = datetime.min
        for el in list(in_carico_set):
            if el[0] == in_carico_key[0]:
                if el[2] == 'NULL':
                    max = datetime.max
                    break
                else:
                    if max < datetime.strptime(el[2].replace("'", ''), '%Y-%m-%d %H:%M:%S'):
                        max = datetime.strptime(el[2].replace("'", ''), '%Y-%m-%d %H:%M:%S')
        if max < datetime.max and in_carico_key[1] >= max:
            in_carico_set.add(in_carico_key)
            d += 1
    else:
        c = True
        for el in list(in_carico_set):
            if el[0] == in_carico_key[0]:
                if str(el[2]) == 'NULL' or not(
                        (in_carico_key[1] >= datetime.strptime(el[2].replace("'", ''), '%Y-%m-%d %H:%M:%S')
                         or (in_carico_key[1] < el[1] and datetime.strptime(in_carico_key[2].replace("'", ''),
                                                                            '%Y-%m-%d %H:%M:%S') <= el[1]))):
                    c = False
                    break
    if c:
        in_carico_set.add(in_carico_key)
        d += 1

StrFinal = StrInsert.format(table='IN_CARICO',
                            columns=[k for k in in_carico.keys()]).replace('[', '').replace(']', '').replace("'", '')
for i in in_carico_set:
    StrFinal += StrValues.format(i[0] + ",'" + str(i[1]) + "'," + i[2] + ',' + i[3] + ',' + str(i[4]))
print(StrFinal[::-1].replace(',', ';', 1)[::-1])

in_carico_pk = len(in_carico_set)
