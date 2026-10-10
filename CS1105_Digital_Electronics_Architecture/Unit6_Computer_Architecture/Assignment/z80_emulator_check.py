"""Re-runs the Z80 examples from the paper on an emulator (pip install z80).

Checks: the main program (A = 5 + 3 stored at 8000h), the Mode 1 keyboard interrupt at 0038h,
and the Mode 2 vectored interrupt (I = 90h, vector 20h, table 9020h -> routine 0200h).
"""
import z80

def mode1():
    m = z80.Z80Machine()
    m.set_memory_block(0x0000, bytes([0x31, 0x00, 0xFF, 0xED, 0x56, 0xFB, 0x3E, 0x05, 0x06, 0x03,
                                      0x80, 0x32, 0x00, 0x80, 0x76, 0x18, 0xFD]))
    m.set_memory_block(0x0038, bytes([0xF5, 0xDB, 0x10, 0x32, 0x01, 0x80, 0xF1, 0xFB, 0xED, 0x4D]))
    m.set_input_callback(lambda port: 0x42)
    m.ticks_to_stop = 200; m.run()
    assert (m.a, m.memory[0x8000], m.halted, m.sp) == (0x08, 0x08, True, 0xFF00)
    m.on_handle_active_int()
    assert (m.pc, m.sp, m.iff1) == (0x0038, 0xFEFE, 0)
    m.ticks_to_stop = 300; m.run()
    assert (m.memory[0x8001], m.a, m.sp, m.iff1) == (0x42, 0x08, 0xFF00, 1)
    print("Mode 1 example: OK")

def mode2():
    m = z80.Z80Machine()
    m.set_memory_block(0x0000, bytes([0x31, 0x00, 0xFF, 0x3E, 0x90, 0xED, 0x47, 0xED, 0x5E, 0xFB,
                                      0x76, 0x18, 0xFD]))
    m.set_memory_block(0x9020, bytes([0x00, 0x02]))
    m.set_memory_block(0x0200, bytes([0x3E, 0x99, 0x32, 0x02, 0x80, 0xFB, 0xED, 0x4D]))
    m.set_get_int_vector_callback(lambda: 0x20)
    m.ticks_to_stop = 200; m.run()
    m.on_handle_active_int()
    assert m.pc == 0x0200
    m.ticks_to_stop = 300; m.run()
    assert m.memory[0x8002] == 0x99
    print("Mode 2 example: OK")

if __name__ == "__main__":
    mode1(); mode2()
